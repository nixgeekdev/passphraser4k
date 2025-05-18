package dev.nixgeek.passphrases

import java.security.SecureRandom

/**
 * A lazily loaded `SecureRandom` object
 */
object Random {
    val secureRandom: SecureRandom
        by lazy { SecureRandom() }
}

/**
 * Roll a dice of a certain type
 * @param type the type of dice to roll: 6 or 20 faces
 */
fun rollDice(type: Int): String {
    require(type in listOf(DICE_FACES_SIX, DICE_FACES_TWENTY)) {
        "invalid dice type: $type"
    }

    return Random.secureRandom
        .nextInt(DICE_ROLLS_LOWER_BOUND, type)
        .toString()
}

/**
 * Roll a dice of a certain type so many times
 * @param howMany how many times to row the dice
 * @param type the type of dice to roll: 6 or 20 faces
 */
fun rollDices(howMany: Int, type: Int): String {
    require(howMany in (DICE_ROLLS_LOWER_BOUND..DICE_ROLLS_UPPER_BOUND)) {
        "invalid number of dice rolls: $howMany"
    }

    return (DICE_ROLLS_LOWER_BOUND..howMany)
        .joinToString(if (type == DICE_FACES_SIX) "" else "-") {
            rollDice(type)
        }
}
