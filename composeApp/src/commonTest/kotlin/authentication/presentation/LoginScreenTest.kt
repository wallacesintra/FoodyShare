package authentication.presentation

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import com.wallace.foodycare.authentication.domain.viewmodels.LoginViewModel
import com.wallace.foodycare.authentication.presentation.LoginPage
import di.testModule
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class LoginScreenTest: KoinComponent{


    @BeforeTest
    fun setupKoin(){

        unloadKoinModules(
            modules = listOf(testModule())
        )

        loadKoinModules(
            modules = listOf(testModule())
        )
    }

    @AfterTest
    fun tearDown(){
        unloadKoinModules(
            listOf(testModule())
        )
    }


    @OptIn(ExperimentalTestApi::class)
    @Test
    fun testLoginScreen() = runComposeUiTest {
        val loginViewModel = get<LoginViewModel>()

        setContent {
            LoginPage()
//            Texting()
        }

        onNodeWithText("FoodyShare").assertExists()
        onNodeWithText("wallace").assertDoesNotExist()
    }
}