# Input Files

All text files in this folder are slightly modified version of the original files 
present at the origin URL. A header with metadata information was added to each file.

The `parse.py` python script will parse the `txt` files into `json` files for consumption 
as a resource in the library. 

## Usage

    parse.py -h -v -p [-i <inputfile>] [-o <outputfile>]

## Sources

| ID                               | Type | Length | URL                                                                           |
|:---------------------------------|:----:|:------:|:------------------------------------------------------------------------------|
| dw.beale.wordlist                |  6   |   5    | https://theworld.com/%7Ereinhold/beale.wordlist.asc                           |
| dw.reinhold.wordlist             |  6   |   5    | https://theworld.com/%7Ereinhold/diceware.wordlist.asc                        |
| eff.8k.gameofthrones.wordlist    |  20  |   3    | https://www.eff.org/files/2018/08/29/gameofthrones_8k-2018.txt                |
| eff.8k.harrypotter.wordlist      |  20  |   3    | https://www.eff.org/files/2018/08/29/harrypotter_8k_3column-txt.txt           | 
| eff.8k.startrek.wordlist         |  20  |   3    | https://www.eff.org/files/2018/08/29/memory-alpha_8k_2018.txt                 |
| eff.8k.starwars.wordlist         |  20  |   3    | https://www.eff.org/files/2018/08/29/starwars_8k_2018.txt                     |
| eff.short.wordlist               |  6   |   4    | https://www.eff.org/files/2016/09/08/eff_short_wordlist_1.txt                 |
| eff.large.wordlist               |  6   |   5    | https://www.eff.org/files/2016/07/18/eff_large_wordlist.txt                   |
| eff.unique.prefix.short.wordlist |  6   |   4    | https://www.eff.org/files/2016/09/08/eff_short_wordlist_2_0.txt               |
| nl.adjectives.wordlist           |  6   |   4    | https://github.com/NaturalLanguagePasswords/system/blob/master/adjectives.pdf |
| nl.nouns.wordlist                |  6   |   5    | https://github.com/NaturalLanguagePasswords/system/blob/master/nouns.pdf      |
