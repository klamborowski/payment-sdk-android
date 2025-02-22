package payment.sdk.android.cardpayment

import payment.sdk.android.core.CardType
import payment.sdk.android.core.OrderAmount
import org.json.JSONObject
import payment.sdk.android.cardpayment.threedsecuretwo.webview.BrowserData

interface PaymentApiInteractor {

    fun authorizePayment(
            url: String,
            code: String,
            success: (List<String>, String) -> Unit,
            error: (Exception) -> Unit)

    fun getOrder(
            orderUrl: String,
            paymentCookie: String,
            success: (String, String, Set<CardType>, OrderAmount, String, JSONObject) -> Unit,
            error: (Exception) -> Unit)

    fun doPayment(
            paymentUrl: String,
            paymentCookie: String,
            pan: String,
            expiry: String,
            cvv: String,
            cardHolder: String,
            success: (state: String, response: JSONObject) -> Unit,
            error: (Exception) -> Unit)

    fun postThreeDSTwoBrowserAuthentications(
            browserData: BrowserData,
            threeDSCompInd: String,
            threeDSAuthenticationsUrl: String,
            paymentCookie: String,
            notificationUrl: String,
            success: (response: JSONObject) -> Unit,
            error: (Exception) -> Unit
    )

    fun postThreeDSTwoChallengeResponse(
            threeDSTwoChallengeResponseURL: String,
            paymentCookie: String,
            success: (state: String, response: JSONObject) -> Unit,
            error: (Exception) -> Unit
    )

    fun getPayerIP(
            requestIpUrl: String,
            paymentCookie: String,
            success: (response: JSONObject) -> Unit,
            error: (Exception) -> Unit
    )
}