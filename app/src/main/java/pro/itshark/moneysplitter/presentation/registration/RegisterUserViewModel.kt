package pro.itshark.moneysplitter.presentation.registration

data class RegisterUserViewModel (
        val password : String,
        val image: String,
        val background: String,
        val email: String,
        val userName: String,
        val surname: String,
        val phoneNumber: Long,
        val creditCardNumber: Long)

