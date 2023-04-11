import java.util.Locale


class UsernameValidator : CheckValidation {

    override fun isvalid(): Boolean {
        return text.isEmpty()
        
    }
}


