package com.sanad.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final int GREEN = Color.rgb(22,184,106);
    final int LIGHT = Color.rgb(225,248,180);
    final int DARK = Color.rgb(23,77,53);
    LinearLayout root, content;
    SharedPreferences prefs;

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        prefs = getSharedPreferences("sanad", MODE_PRIVATE);
        showHome();
    }

    TextView tv(String text, float size) {
        TextView t = new TextView(this);
        t.setText(text);
        t.setTextSize(size);
        t.setTextColor(DARK);
        t.setGravity(Gravity.CENTER);
        t.setPadding(18, 16, 18, 16);
        t.setTextDirection(View.TEXT_DIRECTION_RTL);
        return t;
    }

    Button btn(String text) {
        Button b = new Button(this);
        b.setText(text);
        b.setTextSize(18);
        b.setTextColor(Color.WHITE);
        b.setAllCaps(false);
        b.setBackgroundColor(GREEN);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, 64);
        p.setMargins(22, 9, 22, 9);
        b.setLayoutParams(p);
        return b;
    }

    void base(String pageTitle) {
        ScrollView scroll = new ScrollView(this);
        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(0, 8, 0, 22);
        root.setBackgroundColor(LIGHT);
        scroll.addView(root);
        setContentView(scroll);

        TextView title = tv(pageTitle, 30);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        root.addView(title);

        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        root.addView(content);
    }

    void addBack() {
        Button back = btn("← الرئيسية");
        content.addView(back);
        back.setOnClickListener(v -> showHome());
    }

    void showHome() {
        base("سند");
        TextView intro = tv("رفيقك إلى الخير\nأذكار • أدعية • تسبيح", 20);
        content.addView(intro);

        Button adhkar = btn("📿 الأذكار");
        Button duas = btn("🤲 الأدعية");
        Button tasbeeh = btn("🔢 المسبحة الإلكترونية");
        content.addView(adhkar);
        content.addView(duas);
        content.addView(tasbeeh);

        adhkar.setOnClickListener(v -> showAdhkar());
        duas.setOnClickListener(v -> showDuas());
        tasbeeh.setOnClickListener(v -> showTasbeeh());
    }

    void showAdhkar() {
        base("الأذكار");
        addBack();

        addCard("أذكار الصباح",
            "أصبحنا وأصبح الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير.\n\n" +
            "اللهم بك أصبحنا وبك أمسينا وبك نحيا وبك نموت وإليك النشور.\n\n" +
            "سبحان الله وبحمده.\n\n" +
            "لا إله إلا الله وحده لا شريك له، له الملك وله الحمد وهو على كل شيء قدير.\n\n" +
            "رضيت بالله رباً، وبالإسلام ديناً، وبمحمد ﷺ نبياً.");

        addCard("أذكار المساء",
            "أمسينا وأمسى الملك لله، والحمد لله، لا إله إلا الله وحده لا شريك له.\n\n" +
            "اللهم إني أسألك خير هذه الليلة وخير ما فيها، وأعوذ بك من شرها وشر ما فيها.\n\n" +
            "أعوذ بكلمات الله التامات من شر ما خلق.\n\n" +
            "حسبي الله لا إله إلا هو، عليه توكلت وهو رب العرش العظيم.");

        addCard("أذكار بعد الصلاة",
            "أستغفر الله، أستغفر الله، أستغفر الله.\n\n" +
            "اللهم أنت السلام ومنك السلام، تباركت يا ذا الجلال والإكرام.\n\n" +
            "سبحان الله، والحمد لله، والله أكبر.");

        addCard("أذكار النوم",
            "باسمك اللهم أموت وأحيا.\n\n" +
            "اللهم قني عذابك يوم تبعث عبادك.\n\n" +
            "سبحان الله، والحمد لله، والله أكبر.");

        addCard("أذكار عامة",
            "سبحان الله وبحمده، سبحان الله العظيم.\n\n" +
            "لا حول ولا قوة إلا بالله.\n\n" +
            "أستغفر الله وأتوب إليه.\n\n" +
            "اللهم صل وسلم وبارك على نبينا محمد ﷺ.");
    }

    void showDuas() {
        base("الأدعية");
        addBack();

        addCard("دعاء طلب الخير",
            "ربنا آتنا في الدنيا حسنة وفي الآخرة حسنة وقنا عذاب النار.");

        addCard("دعاء العلم",
            "رب زدني علماً.");

        addCard("دعاء التيسير",
            "رب اشرح لي صدري ويسر لي أمري واحلل عقدة من لساني يفقهوا قولي.");

        addCard("دعاء المغفرة",
            "رب اغفر لي ولوالدي وللمؤمنين يوم يقوم الحساب.");

        addCard("دعاء الرزق",
            "اللهم اكفني بحلالك عن حرامك، وأغنني بفضلك عمن سواك.");

        addCard("دعاء الهم والحزن",
            "اللهم إني أعوذ بك من الهم والحزن، وأعوذ بك من العجز والكسل.");

        addCard("دعاء الوالدين",
            "رب ارحمهما كما ربياني صغيراً.");

        addCard("دعاء السفر",
            "سبحان الذي سخر لنا هذا وما كنا له مقرنين، وإنا إلى ربنا لمنقلبون.");

        addCard("دعاء دخول المنزل",
            "بسم الله ولجنا، وبسم الله خرجنا، وعلى ربنا توكلنا.");

        addCard("دعاء جامع",
            "اللهم إني أسألك الهدى والتقى والعفاف والغنى.");

        addCard("دعاء راحة القلب",
            "اللهم اجعل في قلبي نوراً، وفي سمعي نوراً، وفي بصري نوراً، وعن يميني نوراً، وعن شمالي نوراً.");

        addCard("دعاء حسن الخاتمة",
            "يا مقلب القلوب ثبت قلبي على دينك.");
    }

    void addCard(String heading, String body) {
        TextView h = tv(heading, 22);
        h.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        h.setTextColor(GREEN);
        content.addView(h);

        TextView b = tv(body, 20);
        b.setGravity(Gravity.RIGHT);
        b.setBackgroundColor(Color.WHITE);
        b.setPadding(24, 22, 24, 22);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-1, -2);
        p.setMargins(18, 4, 18, 14);
        b.setLayoutParams(p);
        content.addView(b);
    }

    void showTasbeeh() {
        base("المسبحة الإلكترونية");
        addBack();

        TextView hint = tv("اضغط على الزر بعد كل تسبيحة", 18);
        content.addView(hint);

        TextView counter = tv(String.valueOf(prefs.getInt("count", 0)), 64);
        counter.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        content.addView(counter);

        Button plus = btn("سبحان الله  •  +1");
        Button reset = btn("إعادة العداد");
        content.addView(plus);
        content.addView(reset);

        plus.setOnClickListener(v -> {
            int n = prefs.getInt("count", 0) + 1;
            prefs.edit().putInt("count", n).apply();
            counter.setText(String.valueOf(n));
        });

        reset.setOnClickListener(v -> {
            prefs.edit().putInt("count", 0).apply();
            counter.setText("0");
        });
    }
}
