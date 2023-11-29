import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.MutableState
import com.example.infosyscodingtest.data_layer.local_data_source.models.AuCitiesItem
import com.example.infosyscodingtest.presentation_layer.components.CitiDetails
import com.example.infosyscodingtest.presentation_layer.components.CitiTitle

fun String.showToast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_LONG).show()
}

fun LazyListScope.CitiItem(
    citi: AuCitiesItem,
    isExpanded: Boolean,
    onCitiClicked: () -> Unit
) {

    item {
        CitiTitle(
            name = citi.city.toString(),
            isExpanded = isExpanded,
            onCitiClicked = onCitiClicked
        )
    }

    if (isExpanded){
        item{
            CitiDetails(auCitiesItem = citi)
        }
    }
}