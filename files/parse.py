#!/usr/bin/env python3

import getopt
import sys
import os
import json
from datetime import datetime


JSON_FILE_EXT = ".json"
TEXT_FILE_EXT = ".txt"
WORDLIST_EXT = ".wordlist"
USAGE = "Usage: parse.py -h -v -p [-i <inputfile>] [-o <outputfile>]"

pretty_print = False
verbose = False


def file_exists(filename):
    # returns true if a file exists, false otherwise
    if not filename:
        return False
    else:
        # check if the file exists
        if os.path.isfile(filename):
            log("File exists", filename=filename)
            return True
        else:
            # check if the file is a directory
            if os.path.isdir(filename):
                log("File is a directory", filename=filename)
                return False
            else:
                log("File does not exist", filename=filename)
                return False


def log(message, **kwargs):
    # write info to stdout
    if verbose:
        dt = datetime.now()
        print(f"{dt} - {message}: {kwargs}")


def clean():
    # clean up all json output files if they exists
    for filename in os.listdir("."):
        if filename.endswith(JSON_FILE_EXT):
            os.remove(filename)
            log("Removing output file", filename=filename)
    log("Cleaned up JSON files")


def get_all_input_files():
    # get all .txt input files in the current directory
    input_files = []
    for filename in os.listdir("."):
        if filename.endswith(TEXT_FILE_EXT):
            input_files.append(filename)
    if not input_files:
        log("No input files found.")
        sys.exit(2)
    log("Found input files", input_files=input_files)
    return input_files


def get_output_file_from_input(input_file):
    # get the output file name from the input file name
    # e.g. input_file = "input.txt" -> output_file = "input.json"
    if not input_file.endswith(TEXT_FILE_EXT):
        log("Input file does not have the correct extension.")
        sys.exit(2)
    output_file = parse_id(input_file) + JSON_FILE_EXT
    log("Output file name", output_file=output_file)
    return output_file


def read_data(filename):
    # read data from text file
    with open(filename) as f:
        data = f.read()
    log("Reading data from file", filename=filename)
    if not data:
        log("File is empty", filename=filename)
        sys.exit(2)
    return data


def dump_json(filename, data):
    # save data to a json file
    with open(filename, mode="w", encoding="utf-8") as f:
        json.dump(data, f, indent = 2 if pretty_print else None, ensure_ascii=False)
    log("Dumping data to JSON file", filename=filename)


def parse_id(filename):
    # parse the id from the filename
    return filename[:-4]


def parse_opts():
    # parse command line options
    input_file = None
    output_file = None
    try:
        opts, args = getopt.getopt(sys.argv[1:], "hvpi:o:", ["help", "verbose", "pretty-print", "input=", "output="])
    except getopt.GetoptError as err:
        log(str(err))
        print(USAGE)
        sys.exit(2)

    for opt, arg in opts:
        if opt in ("-h", "--help"):
            print(USAGE)
            sys.exit()
        elif opt in ("-v", "--verbose"):
            global verbose
            verbose = True
        elif opt in ("-p", "--pretty-print"):
            global pretty_print
            pretty_print = True
        elif opt in ("-i", "--input"):
            input_file = arg
        elif opt in ("-o", "--output"):
            output_file = arg
        else:
            assert False, "unhandled option"
    log("Parsed options", verbose=verbose, pretty_print=pretty_print, input_file=input_file, output_file=output_file)
    return (input_file, output_file)


def validate(input_file, output_file):
    # validate input and output files
    if not input_file:
        log("Input file not specified")
    if not file_exists(input_file):
        log("Input file does not exist. Parsing all files")
        return
    if not output_file:
        log("Output file not specified", output_file=output_file)
        sys.exit(2)
    if file_exists(output_file):
        log("Output file already exists", output_file=output_file)
        sys.exit(2)
    if not output_file.endswith(JSON_FILE_EXT):
        log("Output file does not have the correct extension", output_file=output_file)
        sys.exit(2)
    if not input_file.endswith(TEXT_FILE_EXT):
        print("Input file does not have the correct extension", input_file=input_file)
        sys.exit(2)


def parse_header(header):
    # parse the header from the input file
    # header is a string with key=value pairs
    # separated by newlines
    # e.g. "key1=value1\nkey2=value2\n"
    header_dict = {}
    lines = header.split("\n")
    for line in lines:
        if line.strip():
            key, value = line.split("=", 1)
            header_dict[key.strip()] = value.strip()
    return header_dict


def parse_wordlist(data):
    # parse the wordlist from the input file
    # wordlist is a string with key value pairs
    # each pair is separated by a newline
    # and the key and value are separated by whitespace
    wordlist = {}
    lines = data.split("\n")
    for line in lines:
        if line.strip():
            try:
                key, value = line.split()
            except ValueError:
                print(f"Error parsing line: {line}")
                sys.exit(2)
            wordlist[key.strip()] = value.strip()
    return wordlist


def do_work(input_file, output_file):
    # do the work of parsing the input file and writing to the output file
    input_data = read_data(input_file)
    input_header, input_wordlist = input_data.split("----\n")
    parsed_header = parse_header(input_header)
    parsed_wordlist = parse_wordlist(input_wordlist)
    output_data = parsed_header
    output_data["wordlist"] = parsed_wordlist
    dump_json(output_file, output_data)


def main():
    # main function
    input_file, output_file = None, None
    input_file, output_file = parse_opts()
    validate(input_file, output_file)
    if (not input_file) and (not output_file):
        clean()
        for input_file in get_all_input_files():
            output_file = get_output_file_from_input(input_file)
            do_work(input_file, output_file)
    elif input_file and output_file:
        do_work(input_file, output_file)


if __name__ == "__main__":
    main()
