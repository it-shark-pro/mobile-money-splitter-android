package pro.itshark.moneysplitter.presentation.userProfile

data class UserModel(
        val id: Int,
        val email: String,
        val name: String,
        val surname: String,
        val phoneNumber: Int,
        val creditCardNumber: Long,
        val balance: Float,
        val token: String,
        val imageUrl: String,
        val backgroundImageUrl: String
)