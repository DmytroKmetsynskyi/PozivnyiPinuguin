package com.fernfog.pozivnyPinguin;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.ListResult;
import com.google.firebase.storage.StorageReference;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String[] pozivni = {"Абема","Абрам","Абрамс","Абрикос","Абур","Адвокат","Адольф","Ажур","Азар","Азарт","Азєр","Айран","Акбар","Акула","Алєкс","Алжир","Алий","Алі","Аллах","Алтай","Альоша","Альфа","Амугус","Амур","Ангар","Апостол","Арієць","Арсен","Арсенал","Арта","Артист","Арчі","Аул","Афоня","Афоня","Африка","Баггі","Багіра","Байден","Байт","Бак","Бакс","Бакс","Балу","Балу","Бальзам","Бам","Бампер","Банан","Банан","Бандера","Банзай","Банк","Банкір","Бант","Барбарис","Барон","Барон","Барс","Барс","Барс","Бас","Батут","Батя","Башня ","Баян","Бджілка","Бен","Беркут","Берлин","Бермікс","Бетмен","Беха","Бєлка","Бєня","Бидло","Бизон","Бик","Бик","Бідон","Бізон","Біл","Білий","Білл","Білорус","Біма","Бімер","Біт","Біцуха","Блек","Боб","Бодя","Боксер ","Борода","Боря","Босий","Босяк","Бочка","Брама","Брат","Братан","Брейк","Брест","Бром","Буг","Буг","Бул","Булка","Бульдог","Бумер","Буратіно","Бурий ","Буряк","Бутер","Бутиль","Буян","В'юн","Вагон","Вазілін","Вайс","Вакул","Валас","Валєт","Валина","Вампір","Вандал","Варус","Вега","Веган","Вейп","Вєлік","Вєлік","Вєрний","Вир","Віз","Вій","Вінниця","Віраж","Вітамін","Влучко","Вовк","Воз","Волинь","Волонтер","Волос","Волосатий","Ворон","Вуйко","Вус","Газ","Гама","Гарик","Гашиш","Гвоздь","Гвоздь","Герб","Гємор","Гєна","Гєндальф","Гиря","Гіві","Гід","Гільза","Гітаріст ","Гній","Гном","Гном","Гога","Горб","Горбатий","Горинич","Горіх","Град","Граду","Грамм","Граніт","Грек","Гречка","Гривня","Губа","Губка","Гуталін","Гуцул","Гюрза","Далі","Далі","Далі","Дацент","Двіж","Дес","Дєд","Джек","Джигурда","Джин","Джин","Джинс","Джміль","Джокер","Джон","Джура","Джус","Дизиль","Дикий","Дикий","Дим","Дишак","Дід","Дізєль","Дісіптікон","Дніпро","Довбань","Додо","Док","Доллар","Дон","Дорий","Дощ","Драго","Дред","Дрель","Дуб","Дудка","Дунай","Дуфалан","Дядя","Едгард","Ексель","Ельф","Ельф","Ержан","Ерік","Євро","Єнот","Жак","Жид","Жижа","Жир","Жирний","Жміль","Жмур","Жолудь","Жора","Завуч","Загар","Загон","Запор","Захар","Захід","Зек","Зепер","Зефір","Зєніт","Змій","Знахарь","Знахарь","Зонт","Зьома","Ізюм","Індіка","Іраниць","Іспанець","Ісус","Їдло","Йоська","Кабак","Кабан","Кавказ","Каго","Кагор","Кагор","Казах","Казік","Казік","Каін","Каін","Кай","Кайф","Кайфарік","Кактус","Калина","Калібр","Калібр","Камаз","Камиш","Камиш","Канада","Канада","Карандаш","Карась","Карат","Карма","Карп","Картавий","Картон","Картошка","Каста","Кафель","Кац","Каша","Каштан","Кефір","Кеш","Кєкс","Кєнт","Кий","Киргиз","Китаєць","Китай","Киця","Кіборг","Ківі","Кізяк","Кінза","Кінконг","Кіно","Кінь","Кіпіш","Кіпр","Кіпріот","Кіт","Клин","Кличко","Клізма","Кльопа","Кляча","Кнопка","Князь","Кобзар","Кобра","Коваль","Ковбань","Коза","Козак","Койот","Кокон","Кокос","Кокс","Кокс","Кола","Колдун","Комар","Комп","Компот","Комсомол","Комуніст","Копія","Корд","Корєш","Корж","Коржик","Корсар","Кось","Кощєй","Краб","Кража","Крафт","Крем","Крим","Криса","Крінж","Кріт","Крокус","Крос","Круг","Крутий","Куб","Куб","Кубік","Кудрявий","Кузя","Кук","Куля","Куниця","Куні","Куня","Курок","Кучма","Лакі","Лангуст","Ланос","Ларьок","Ласка","Лєший","Лєший","Лис","Лисий","Лисий","Лір","Лісник","Літр","Ліфт","Ложка","Лотос","Лофт","Луцьк","Львів","Люк","Люм","Лютий","Лютік","Ляля","Ляпіс","Лях","Ляшко","Маг","Маджанжа","Мадрід","Мадяр","Мазік","Мазут","Мазута","Мак","Макун","Малий","Малий","Малина","Малиш","Малі","Мальок","Мама","Мамай","Мамонт","Манту","Марка","Марлі","Марс","Марсель","Мартін","Маршал","Масло","Матісс","Мафіознік","Мелман","Мер","Местро","Митя","Михась","Миш","Міг","Міг","Міка","Мінус","Мойва","Молдаван","Молдова","Монгол","Моно","Мопс","Мор","Мор","Морті","Мосад","Мотолига","Мотомото","Моторола","Моцарт","Мультік","Мур","Мурка","Муха","Навара","Нарик","Нарік","Нетреба","Нєгр","Нива","Німець","Ніндзя","Нітро","Новік","Новус","Нолік","Норд","Носок","Носок","Нут","Нутрій ","Обама","Одесит","Окко","Око","Олень","Олово","Омар","Омлєт","Орда","Оцет","Палець","Палка","Палкан","Панда","Парафін","Парик","Паскаль","Патрон","Патрон","Пахан","Паштєт","Персик","Пес","Пєгас","Пижик","Пискун","Піка","Пістон","Піська","Пісюн","Піфагор","Плюс","Плюшкін","Покемон","Поляк","Помідор","Понос","Пончік","Пончіто","Поп","Попкорн","Поріг","Порох","Пост","Прєзік","Пробіл","Програміст","Прокоп","Промінь","Пропер","Проц","Прут","Пряник","Пузирь","Пульт","Пуля","Пупс","Пятнистий","Рак","Ральф","Рама","Ранчо","Рат","Регбі","Редбул","Редис","Редиска","Рекрут","Ренжик","Рижий","Рижий","Ріал","Рік","Ріф","Ровер","Роза","Ром","Рошен","Рубік","Рубль","Румин","Рута","Сайга","Саймон","Сайт","Сальто","Самбо","Самодєлкін","Самсон","Самурай","Санич","Санітар","Сапсан","Сатана","Сатіва","Сахар","Святий","Сендвіч","Сєга","Син","Синій","Сир","Сир","Сіга","Сіджей","Сіль","Сільпо","Сіменс","Січень","Сківрт","Скільптор","Скіф","Скунс","Скуф","Славута","Слов","Слон","Сніг","Снігур","Соболь","Сок","Солдат","Сом","Сонце","Сперма","Спортік","Старий","Старший","Степан","Сторож","Стресс","Студент","Суєтолог","Султан","Суп","Сушка","Схід","Східняк","Сцикун","Сява","Сява","Сяомі","Сяомі","Табжик","Тагір","Тайвань","Тайсон","Тайсон","Тайфун","Такер","Талмуд","Тамада","Тапок","Тарас","Таро","Татар","Тен","Терен","Террі","Тесла","Тєлік","Тєрмінатор","Тиса","Тиса","Тихий","Тімон","Тір","Тітан","Тіхон","Тодо","Том","Томас","Тон","Тор","Торч","Торчок","Трава","Трамп","Транс","Трек","Тріпер","Тріпер","Трітій","Тропік","Трудовик","Трюфель","Туз","Турист","Турок","Уксус","Умка","Усік","Ухилянт","Фаб","Файл","Фантік","Фара","Фараон","Фарш","Фауст","Фермер","Фізрук","Фізрук","Фіксік","Фікус","Фін","Флірт","Фоє","Фокс","Фокс","Фоп","Француз","Фрукт","Фрукт","Футболіст","Хакер","Халк","Хантер","Ханурік","Харам","Хаус","Хєсус","Хижак","Хліб","Хобіт","Хобіт","Холодос","Хома","Хорив","Хортиця","Хохол","Хрест","Хрущ","Цап","Цвях","Цезарь","Цезарь","Цезій","Цезій","Циган","Циклоп","Цирк","Циркуль","Цитрамон","Цицька","Циця","Цой","Цом","Цукор","Цунамі","Чабан","Чаклун","Чапа","Чаппі","Чарка","Чарка","Чепа","Черкаш","Чех","Чєл","Чижик","Чіназес","Чіча","Чмо","Чоп","Чорний","Чорт","Чукча","Чумазий ","Чунга","Чунгачанга","Чурка","Чучєл","Чуш","Шабат","Шабо","Шалений","Шаман","Шашлик","Шварц","Шева","Шейк","Шейх","Шелбі","Шеф","Шифр","Шкіла","Шлюб","Шнур","Шок","Шольц","Шпиц","Шрам","Шредер","Шрек","Штанга","Штурмик","Шум","Шурік","Шуруп","Шухєр","Щавель","Щек","Юджин","Юкас","Юрист","Яга","Ялта","Японець"};
    int[] pictures = {R.drawable.default_a_cute_3d_cartoon_penguin_looks_out_of_a_military_tank_0,
            R.drawable.default_a_cute_3d_cartoon_penguin_looks_out_of_a_military_tank_1,
            R.drawable.default_a_cute_3d_cartoon_penguin_looks_out_of_a_military_tank_2,
            R.drawable.default_a_cute_3d_cartoon_penguin_looks_out_of_a_military_tank_3,
            R.drawable.default_a_cute_cartoon_penguin_looks_out_of_a_military_tank_0,
            R.drawable.default_a_cute_cartoon_penguin_looks_out_of_a_military_tank_1,
            R.drawable.default_a_cute_cartoon_penguin_shoots_enemies_with_an_arty_3,
            R.drawable.default_a_cute_penguin_at_the_wheel_of_a_fighter_jet_1,
            R.drawable.default_a_cute_penguin_at_the_wheel_of_a_fighter_jet_2,
            R.drawable.default_a_cute_penguin_at_the_wheel_of_a_fighter_jet_3,
            R.drawable.default_a_penguin_with_a_kalashnikov_assault_rifle_in_his_hand_0,
            R.drawable.default_a_penguin_with_a_kalashnikov_assault_rifle_in_his_hand_1,
            R.drawable.default_a_penguin_with_a_kalashnikov_assault_rifle_in_his_hand_2,
            R.drawable.default_a_penguin_with_a_kalashnikov_assault_rifle_in_his_hand_3,
            R.drawable.default_cute_3d_penguin_general_at_war_0,
            R.drawable.default_cute_3d_penguin_general_at_war_1,
            R.drawable.default_cute_3d_penguin_general_at_war_2,
            R.drawable.default_cute_3d_penguin_general_at_war_3,
            R.drawable.default_cute_3d_penguin_sniper_at_war_0,
            R.drawable.default_cute_3d_penguin_sniper_at_war_1,
            R.drawable.default_cute_3d_penguin_sniper_at_war_2,
            R.drawable.default_cute_penguin_with_weapon_0,
            R.drawable.default_cute_penguin_with_weapon_1,
            R.drawable.default_cute_penguin_with_weapon_2,
            R.drawable.default_cute_penguin_with_weapon_3,
            R.drawable.default_cute_ukrainian_3d_penguin_at_war_0,
            R.drawable.default_cute_ukrainian_3d_penguin_at_war_1,
            R.drawable.default_cute_ukrainian_3d_penguin_at_war_2,
            R.drawable.default_cute_ukrainian_3d_penguin_at_war_3,
            R.drawable.default_cute_ukrainian_3d_penguin_attack_aircraft_at_war_2,
            R.drawable.default_cute_ukrainian_3d_penguin_attack_aircraft_at_war_3,
            R.drawable.default_cute_ukrainian_3d_penguin_attack_aircraft_at_war_3__1_,
            R.drawable.default_cute_ukrainian_3d_penguin_with_gun_0,
            R.drawable.default_cute_ukrainian_3d_penguin_with_gun_1,
            R.drawable.default_cute_ukrainian_3d_penguin_with_gun_2,
            R.drawable.default_cute_ukrainian_3d_penguin_with_gun_3,
            R.drawable.default_penguin_in_military_uniform_with_weapon_0,
            R.drawable.default_penguin_in_military_uniform_with_weapon_1,
            R.drawable.default_penguin_in_military_uniform_with_weapon_2,
            R.drawable.default_penguin_in_military_uniform_with_weapon_0__1_,
            R.drawable.default_penguin_in_military_uniform_with_weapon_1__1_,
            R.drawable.default_penguin_in_military_uniform_with_weapon_2__1_,
            R.drawable.default_penguin_in_military_uniform_with_weapon_3__1_,
    };

    private InterstitialAd mInterstitialAd;
    private RewardedAd rewardedAd;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    ImageView imageView;
    TextView textView;
    MaterialButton materialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPref = this.getSharedPreferences("shared", Context.MODE_PRIVATE);
        editor = sharedPref.edit();

        imageView = findViewById(R.id.image);
        textView = findViewById(R.id.textttttt);
        materialButton = findViewById(R.id.button);

        new Thread(() -> {MobileAds.initialize(this, initializationStatus -> {});}).start();

        loadInter();
        loadReward();

        getRandomPozivniy();

        materialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRandomPozivniy();
            }
        });

    }


    public void getRandomPozivniy() {
        Glide.with(MainActivity.this).load(pictures[new Random().nextInt(pictures.length)]).into(imageView);
        textView.setText(pozivni[new Random().nextInt(pozivni.length)].toUpperCase());

        if (rewardedAd != null && mInterstitialAd != null) {
            int num10 = sharedPref.getInt("num10", 0);
            num10+=1;
            editor.putInt("num10", num10);
            editor.apply();

            int num50 = sharedPref.getInt("num50", 0);
            num50+=1;
            editor.putInt("num50", num50);
            editor.apply();

            if (num50 >= 50) {
                rewardedAd.show(MainActivity.this, new OnUserEarnedRewardListener() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {

                    }
                });
                editor.putInt("num50", 0);
                editor.apply();
                loadReward();
            } else if (num10 >= 10) {
                mInterstitialAd.show(MainActivity.this);
                editor.putInt("num10", 0);
                editor.apply();
                loadInter();
            }
        } else {
            loadReward();
            loadInter();
        }
    }

    public void loadReward() {
        AdRequest adRequest_ = new AdRequest.Builder().build();
        RewardedAd.load(this, "ca-app-pub-3940256099942544/5224354917",
                adRequest_, new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        rewardedAd = null;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedAd = ad;
                    }
                });
    }

    public void loadInter() {
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        mInterstitialAd = null;
                    }
                });
    }
}