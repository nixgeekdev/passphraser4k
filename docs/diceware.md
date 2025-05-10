# DiceWare

Weak passwords and passphrases are one of the most common flaws in computer
security. The Diceware method offers a better way to create a strong, yet easy
to remember, passphrase for use with encryption and security programs.

## What Is A Passphrase?

A passphrase is a sequence of words or characters used as a password to secure
access to a system, device, or account. Unlike traditional passwords, which are
typically short and contain a combination of letters, numbers, and symbols,
passphrases are longer and consist of multiple words strung together.

The purpose of a passphrase is to enhance the security of an authentication
process by increasing its complexity and resistance to brute-force attacks. By
using a longer sequence of words, passphrases can be more memorable and easier
to type compared to random combinations of characters.

Passphrases offer several advantages over traditional passwords. They are
generally more resistant to dictionary attacks, where an attacker tries to guess
the password using a list of commonly used words or phrases. Additionally,
passphrases can be easier to remember, reducing the need for users to write them
down or rely on password managers.

To be effective, a passphrase should be unique and not easily guessable. It is
recommended to use a combination of unrelated words that have personal
significance or are memorable to the user, while avoiding commonly used phrases.
Including numbers, symbols, or spaces between words can further enhance the
security of a passphrase.

While passphrases can provide stronger security, it is still important to follow
good password practices such as regularly changing them, avoiding reuse across
different accounts, and keeping them confidential. Using multi-factor
authentication alongside passphrases adds an extra layer of protection,
requiring an additional form of verification to access sensitive information.

Overall, passphrases offer a more user-friendly and secure approach to password
authentication, combining the strength of complex passwords with the ease of
remembering natural language phrases.

## What Is Diceware?

Diceware is a method of generating strong and memorable passwords or passphrases
using dice and a word list. It was created by Arnold Reinhold in 1995 as a way
to create secure passwords that are easy for humans to remember but difficult
for computers to crack.

The process of generating a Diceware passphrase involves rolling a set of dice
and using the results to select words from a pre-defined word list. The word
list consists of a large number of unique and unrelated words, typically 6,000
to 7,776 words, each assigned a five-digit number.

To create a Diceware passphrase, you start by rolling five six-sided dice, or a
single five-sided die, five times. Each roll produces a number between 1 and 6,
or 1 and 5 for the five-sided die. You then use the resulting sequence of
numbers to look up corresponding words in the word list.

For example, if you roll the dice and get the sequence "2-4-6-1-3," you would
look up the word assigned to the number "24613" in the word list. Repeat this
process several times to generate a series of random words, typically around
four to six words.

Here is a short excerpt from the English Diceware word list:

```text
 16662 clean
 16663 clear
 16664 cleat
 16665 cleft
 16666 clerk
 21111 cliche
 21112 click
 21113 cliff
 21114 climb
 21115 clime
 21116 cling
 21121 clink
 21122 clint
 21123 clio
 21124 clip
 21125 clive
```

The resulting passphrase is a combination of these words, which can be used as a
strong and unique password for online accounts or other security purposes.
Diceware passphrases are resistant to brute-force attacks because of the large
number of possible word combinations and the randomness introduced by the dice
rolls.

Diceware provides a simple and effective way to create strong and memorable
passwords without relying on complex algorithms or specialized software. It
empowers individuals to take control of their online security by generating
passwords that are resistant to common cracking techniques.

## Using Diceware

To use the Diceware list you will need one or more ordinary, six-sided dice. Dice 
come with many board games and are sold separately at toy, hobby, and magic 
stores, as well as online. You can purchase a set of five casino-grade dice 
online from Amazon.com or Ebay.com for about $13, but they are overkill for this 
purpose. 

Here's a step-by-step guide on how to use the diceware method to generate secure
and memorable passphrase:

1. Generate a Diceware word list: Obtain a copy of the Diceware word list, which
   consists of a set of unique words associated with a five-digit number. The
   original Diceware word list contains 7776 words. See [wordlists](wordlists.md)
   for more information.
2. Prepare dice or a random number generator: You'll need a way to generate
   random numbers between 1 and 6 (inclusive). You can either use physical dice or
   an online random number generator.
3. Decide on the desired password length: Determine how long you want your
   password to be in terms of the number of words. It is generally recommended to
   use at least four to six words for a strong password.
4. Roll the dice (or generate random numbers): Roll the dice or use a random
   number generator to generate a five-digit number. Repeat this step as many times
   as needed to match the desired password length.
5. Match the numbers to the word list: Take each five-digit number you obtained
   and look it up in the Diceware word list. Find the corresponding word associated
   with that number.
6. Note down the words: Write down each word you obtained from the word list.
   This collection of words will form your diceware passphrase.
7. Combine the words: Concatenate the words together to form your diceware
   passphrase. You can add spaces or other characters between the words if allowed
   by the system you're creating the password for.

### Example

Let's generate a diceware passphrase made up of four words.

Roll the dice (or use a random number generator) four times and obtain the
following results:

- Roll 1: `3-6-2-1-4`
- Roll 2: `2-5-4-3-1`
- Roll 3: `1-4-6-5-2`
- Roll 4: `6-2-1-5-3`

Now, let's match these numbers to the Diceware word list:

- Word 1: `dice` (corresponds to the number 36214)
- Word 2: `charm` (corresponds to the number 25431)
- Word 3: `ache` (corresponds to the number 14652)
- Word 4: `oxide` (corresponds to the number 62153)

Combining these words, our diceware passphrase is `dice charm ache oxide`.

## Why Diceware?

There are many different recommendations available on the Internet about how to 
pick a passphrase. Some are good, a few are bad, but almost all require the 
user to judge what will be hard for someone else to guess. Some give no 
guidance on how to do that, others have you make complex mathematical 
calculations. By contrast, the Diceware method of generating passphrases is:

1. **Security**: Passphrases generated using the Diceware method have high
   entropy, which means they have a large number of possible combinations. This
   makes them resistant to brute-force attacks and significantly increases the
   security of your accounts or systems. For the technically inclined, each word
   in your Diceware passphrase yields 12.9 bits of entropy, the way passphrase
   security is measured. A five word Diceware passphrase would have an entropy
   of at least 64.6 bits; six words would have 77.5 bits, seven words 90.4 bits,
   eight words 103.2 bits. Inserting a letter at random adds about 10 bits of
   entropy.

2. **Randomness**: The Diceware method relies on true randomness by using
   physical dice rolls. It ensures that each word in the passphrase is selected
   independently, making it difficult for attackers to predict or guess the
   passphrase.

3. **Ease of Verification**: Since the Diceware method uses a predefined word
   list, it is easy to verify the strength and security of the generated
   passphrase. By cross-referencing the words with the original word list, you can
   ensure that each word is correctly chosen and hasn't been tampered with.

4. **Memorability**: Diceware passphrases are designed to be memorable. By using
   common words from the word list, it becomes easier for users to remember their
   passphrases without resorting to writing them down or relying on password
   managers. This reduces the risk of passphrases being forgotten or lost.

5. **Simplicity**: The Diceware method is straightforward and easy to
   understand. All you need are dice, a word list, and the ability to follow the
   instructions. There is no complex software or cryptographic algorithms
   involved, making it accessible to a wide range of users.

6. **Offline Generation**: Diceware passphrases can be generated entirely
   offline, eliminating the need for an internet connection or reliance on
   online password generators. This can be particularly beneficial in situations
   where you want to ensure the security and privacy of your passphrase
   generation process.

7. **Openness and Transparency**: The Diceware method is open and transparent.
   The word list and the instructions for generating passphrases are freely
   available and can be audited by security experts or the community at large.
   This openness ensures trust and helps to verify the integrity of the method.

It's important to note that while the Diceware method provides strong
passphrases, the overall security of your accounts and systems also depends on
other factors like protecting against phishing attacks, regularly updating
software, and using two-factor authentication where possible.

Spread the word about Diceware!
