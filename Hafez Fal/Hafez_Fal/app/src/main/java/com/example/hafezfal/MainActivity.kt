package com.example.hafezfal

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainText: TextView = findViewById(R.id.textView)
        mainText.movementMethod = ScrollingMovementMethod()
        val falButton: Button = findViewById(R.id.button)
        val infoButton: Button = findViewById(R.id.button2)

//        val intro = int
//        mainText.text = intro

        falButton.setOnClickListener {
            mainText.scrollTo(0, 0)
            val fal = Fal()
            mainText.text = fal.takeFal()

            val toast =
                Toast.makeText(this, "برای مشاهده بقیه شعر، اسکرول کنید", Toast.LENGTH_SHORT)
            toast.show()
        }

        infoButton.setOnClickListener {
            mainText.scrollTo(0, 0)
            mainText.text =
                "Hafez Fal v1.0.0\nDeveloped by Amirmehdi Zarrinnezhad\n\nContact us: amzarrinnezhad@gmail.com"

            val toast = Toast.makeText(
                this,
                "ممنون می‌شویم با ۵ ستاره از ما حمایت کنید!",
                Toast.LENGTH_LONG
            )
            toast.show()
        }
    }
}

class Fal() {
    fun takeFal(): String {
        val poem1 = "خُرَّم آن روز کز این منزلِ ویران بروم\n" +
                "\n" +
                "راحتِ جان طلبم و از پِیِ جانان بروم\n" +
                "\n" +
                "گر چه دانم که به جایی نَبَرد راه غریب\n" +
                "\n" +
                "من به بویِ سرِ آن زلفِ پریشان بروم\n" +
                "\n" +
                "دلم از وحشتِ زندانِ سِکَندَر بگرفت\n" +
                "\n" +
                "رخت بربندم و تا مُلکِ سلیمان بروم\n" +
                "\n" +
                "چون صبا با تنِ بیمار و دلِ بی\u200Cطاقت\n" +
                "\n" +
                "به هواداریِ آن سروِ خرامان بروم\n" +
                "\n" +
                "در رهِ او چو قلم گر به سرم باید رفت\n" +
                "\n" +
                "با دلِ زخم\u200Cکَش و دیدهٔ گریان بروم\n" +
                "\n" +
                "نذر کردم گر از این غم به درآیم روزی\n" +
                "\n" +
                "تا درِ میکده شادان و غزل\u200Cخوان بروم\n" +
                "\n" +
                "به هواداری او ذَرِّه صفت، رقص کنان\n" +
                "\n" +
                "تا لبِ چشمه\u200Cی خورشیدِ درخشان بروم\n" +
                "\n" +
                "تازیان را غمِ احوالِ گران\u200Cباران نیست\n" +
                "\n" +
                "پارسایان مددی تا خوش و آسان بروم\n" +
                "\n" +
                "ور چو حافظ ز بیابان نبرم رَه بیرون\n" +
                "\n" +
                "همرهِ کوکبهٔ آصفِ دوران بروم"

        val poem2 = "کنون که بر کفِ گل جامِ بادهٔ صاف است\n" +
                "\n" +
                "به صد هزار زبان بلبلش در اوصاف است\n" +
                "\n" +
                "بخواه دفتر اشعار و راهِ صحرا گیر\n" +
                "\n" +
                "چه وقتِ مدرسه و بحث کشف کَشّاف است؟\n" +
                "\n" +
                "فقیه مدرسه دی مست بود و فتوی داد\n" +
                "\n" +
                "که می حرام، ولی بِه ز مالِ اوقاف است\n" +
                "\n" +
                "به دُرد و صاف تو را حکم نیست خوش دَرکَش\n" +
                "\n" +
                "که هر چه ساقی ما کرد عینِ الطاف است\n" +
                "\n" +
                "بِبُر ز خلق و چو عَنقا قیاس کار بگیر\n" +
                "\n" +
                "که صیت گوشه نشینان ز قاف تا قاف است\n" +
                "\n" +
                "حدیثِ مدعیان و خیالِ همکاران\n" +
                "\n" +
                "همان حکایت زردوز و بوریاباف است\n" +
                "\n" +
                "خموش حافظ و این نکته\u200Cهای چون زر سرخ\n" +
                "\n" +
                "نگاه دار که قَلّابِ شهر، صراف است\n"

        val poem3 = "\n" +
                "آن شبِ قدری که گویند اهل خلوت امشب است\n" +
                "\n" +
                "یا رب این تأثیرِ دولت در کدامین کوکب است؟\n" +
                "\n" +
                "تا به گیسوی تو دست ناسزایان کم رسد\n" +
                "\n" +
                "هر دلی از حلقه\u200Cای در ذکر یارب یارب است\n" +
                "\n" +
                "کشته چاه زنخدان توام کز هر طرف\n" +
                "\n" +
                "صد هزارش گردن جان زیرِ طوقِ غبغب است\n" +
                "\n" +
                "شهسوار من که مه آیینه دار روی اوست\n" +
                "\n" +
                "تاجِ خورشیدِ بلندش خاکِ نعلِ مرکب است\n" +
                "\n" +
                "عکس خِوی بر عارضش بین کآفتاب گرم رو\n" +
                "\n" +
                "در هوای آن عرق تا هست هر روزش تب است\n" +
                "\n" +
                "من نخواهم کرد ترک لعل یار و جام می\n" +
                "\n" +
                "زاهدان معذور داریدم که اینم مذهب است\n" +
                "\n" +
                "اندر آن ساعت که بر پشت صبا بندند زین\n" +
                "\n" +
                "با سلیمان چون برانم من که مورم مرکب است\n" +
                "\n" +
                "آن که ناوک بر دل من زیر چشمی می\u200Cزند\n" +
                "\n" +
                "قوتِ جانِ حافظش در خندهٔ زیر لب است\n" +
                "\n" +
                "آب حیوانش ز منقار بلاغت می\u200Cچکد\n" +
                "\n" +
                "زاغِ کِلکِ من به نام ایزد چه عالی مشرب است"

        val poem4 = "یوسفِ گُم گشته بازآید به کنعان، غم مَخُور\n" +
                "\n" +
                "کلبهٔ احزان شَوَد روزی گلستان، غم مخور\n" +
                "\n" +
                "ای دل غمدیده، حالت بِه شود، دل بَد مکن\n" +
                "\n" +
                "وین سرِ شوریده باز آید به سامان غم مخور\n" +
                "\n" +
                "گر بهارِ عمر باشد باز بر تختِ چمن\n" +
                "\n" +
                "چتر گل در سر کَشی، ای مرغِ خوشخوان غم مخور\n" +
                "\n" +
                "دورِ گردون گر دو روزی بر مرادِ ما نرفت\n" +
                "\n" +
                "دائماً یکسان نباشد حالِ دوران غم مخور\n" +
                "\n" +
                "هان مَشو نومید چون واقِف نِه\u200Cای از سِرِّ غیب\n" +
                "\n" +
                "باشد اندر پرده بازیهایِ پنهان غم مخور\n" +
                "\n" +
                "ای دل اَر سیلِ فنا بنیادِ هستی بَر کَنَد\n" +
                "\n" +
                "چون تو را نوح است کشتیبان، ز طوفان غم مخور\n" +
                "\n" +
                "در بیابان گر به شوقِ کعبه خواهی زد قدم\n" +
                "\n" +
                "سرزنشها گر کُنَد خارِ مُغیلان غم مخور\n" +
                "\n" +
                "گر چه منزل بس خطرناک است و مقصد بس بعید\n" +
                "\n" +
                "هیچ راهی نیست، کان را نیست پایان، غم مخور\n" +
                "\n" +
                "حال ما در فِرقت جانان و اِبرامِ رقیب\n" +
                "\n" +
                "جمله می\u200Cداند خدایِ حالْ گردان غم مخور\n" +
                "\n" +
                "حافظا در کُنجِ فقر و خلوتِ شبهایِ تار\n" +
                "\n" +
                "تا بُوَد وِردَت دعا و درسِ قرآن غم مخور"

        val poem5 = "حالِ دل با تو گفتنم هوس است\n" +
                "\n" +
                "خبرِ دل شِنُفتَنَم هوس است\n" +
                "\n" +
                "طمعِ خام بین که قصهٔ فاش\n" +
                "\n" +
                "از رقیبان نهفتنم هوس است\n" +
                "\n" +
                "شبِ قدری چنین عزیزِ شریف\n" +
                "\n" +
                "با تو تا روز خُفتنم هوس است\n" +
                "\n" +
                "وه که دُردانه\u200Cای چنین نازک\n" +
                "\n" +
                "در شبِ تار سُفتنم هوس است\n" +
                "\n" +
                "ای صبا امشبم مدد فرمای\n" +
                "\n" +
                "که سحرگه شکفتنم هوس است\n" +
                "\n" +
                "از برای شرف به نوُکِ مژه\n" +
                "\n" +
                "خاکِ راهِ تو رفتنم هوس است\n" +
                "\n" +
                "همچو حافظ به رغمِ مدعیان\n" +
                "\n" +
                "شعرِ رندانه گفتنم هوس است"
        val poems = arrayOf(poem1, poem2, poem3, poem4, poem5)

        return poems.random()
    }
}