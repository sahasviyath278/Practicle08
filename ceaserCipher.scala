package practicle8

import scala.io.StdIn

object ceaserCipher {
  def encrypt(text: String, shift: Int): String = {
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    val encryptedText = text.map { char =>
      if (char.isLetter) {
        val isUpperCase = char.isUpper
        val index = alphabet.indexOf(char.toUpper)
        val newIndex = (index + shift + alphabet.length) % alphabet.length
        val newChar = alphabet(newIndex)
        if (isUpperCase) newChar else newChar.toLower
      } else {
        char
      }
    }
    encryptedText.mkString
  }

  def decrypt(text: String, shift: Int): String = {
    encrypt(text, -shift)
  }

  def cipher(
              text: String,
              shift: Int,
              operation: (String, Int) => String
            ): String = {
    operation(text, shift)
  }

  def run(): Unit = {
    println("Enter the text to encrypt:")
    val plaintext = StdIn.readLine()

    println("Enter the shift value:")
    val shift = StdIn.readInt()

    val encryptedText = cipher(plaintext, shift, encrypt)
    println(s"Encrypted text: $encryptedText")

    val decryptedText = cipher(encryptedText, shift, decrypt)
    println(s"Decrypted text: $decryptedText")
  }
}
