import android.content.Context
import android.os.Parcelable
import com.vicsothemes.recyclerview.R
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Letters(
    val id: Int,
    val banner: Int,
    val title: String,
    val description: String,
    val sample: String

) : Parcelable {

    companion object {
        fun lettersList(context: Context): List<Letters> {
            return listOf(

                Letters(
                    0, R.drawable.ic_a,
                    context.getString(R.string.letter_a),
                    context.getString(R.string.about_a),
                    context.getString(R.string.sample_a)

                ),
                Letters(1, R.drawable.ic_b,
                    context.getString(R.string.letter_b),
                    context.getString(R.string.about_b),
                    context.getString(R.string.sample_b)

                ),
                Letters(2, R.drawable.ic_d,
                    context.getString(R.string.letter_d),
                    context.getString(R.string.about_d),
                    context.getString(R.string.sample_d)
                )
            )
        }
    }
}