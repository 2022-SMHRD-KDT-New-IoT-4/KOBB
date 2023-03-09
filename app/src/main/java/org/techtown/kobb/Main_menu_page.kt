package org.techtown.kobb

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import java.util.*

class Main_menu_page : AppCompatActivity() {

    lateinit var textToSpeech: TextToSpeech
    lateinit var  a : String
    //매장명
    lateinit var user_shop_name : String
    lateinit var eat:String
    //음성
    lateinit var  voice : String
    lateinit var text : String
    lateinit var tts :TextToSpeech
    lateinit var cnt :String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu_page)
        //음성출력
        tts = TextToSpeech(this, TextToSpeech.OnInitListener {
            if (it != TextToSpeech.ERROR){
                tts.language = Locale.KOREAN
            }
        })
        initTextToSpeech()

        //먹고가기 포장하기
        if(intent.getStringExtra("먹고가기")!=null){
            eat = intent.getStringExtra("먹고가기")!!

        }else{
            eat =intent.getStringExtra("포장하기")!!
        }


        //상호명
        var tvmenu= findViewById<TextView>(R.id.tvcname)
        //받아온 매장명
        user_shop_name = intent.getStringExtra("매장명")!!
        //상호명에 받아온 매장명 담아주기
        tvmenu.text = user_shop_name
        // 6개 버튼 소메뉴 페이지(small_menu_page) 로 이동
        var btn_small_menu_page1 = findViewById<Button>(R.id.btn_small_menu_page1)
        var btn_small_menu_page2 = findViewById<Button>(R.id.btn_small_menu_page2)
        var btn_small_menu_page3 = findViewById<Button>(R.id.btn_small_menu_page3)
        var btn_small_menu_page4 = findViewById<Button>(R.id.btn_small_menu_page4)
        var btn_small_menu_page5 = findViewById<Button>(R.id.btn_small_menu_page5)
        var btn_small_menu_page6 = findViewById<Button>(R.id.btn_small_menu_page6)
        //커피 버튼
        btn_small_menu_page1.setOnClickListener{
            //현재 페이지에서 버튼을 눌렀을 때 출력되는 음성
            cnt="커피 메뉴를 선택하셨습니다. 아메리카노 1번. 에스프레소 2번"
            voice = cnt
            //다음 페이지로 넘기는 음성 값
            //cnt = "아메리카노를 선택하셨습니다. 차갑게 드실려면 1번.따뜻하게 드실려면2번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this@Main_menu_page,small_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            intent.putExtra("cnt1",cnt)
            startActivity(intent)

        }
        //라떼 버튼
        btn_small_menu_page2.setOnClickListener{
            cnt="라떼 메뉴를 선택하셨습니다. 바닐라라떼 1번. 카페라떼는 2번"
            voice = cnt
          //  cnt = "카페라떼. 차갑게 드실려면 1번.따뜻하게 드실려면2번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this@Main_menu_page,small_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            intent.putExtra("cnt2",cnt)
            startActivity(intent)
        }
        //차 버튼
        btn_small_menu_page3.setOnClickListener{
            cnt="차 메뉴를 선택하셨습니다. 차차차는 1번. 칡 차는 2번"
            voice = cnt
           // cnt = "케이크. 차갑게 드실려면 1번.따뜻하게 드실려면2번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this@Main_menu_page,small_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            intent.putExtra("cnt3",cnt)
            startActivity(intent)
        }
        //에이드
        btn_small_menu_page4.setOnClickListener{
            cnt = "에이드 메뉴를 선택하셨습니다. 망고에이드는  1번. 레몬에이드는 2번"
            voice = cnt
           // cnt = "레몬에이드. 차갑게 드실려면 1번.따뜻하게 드실려면2번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this@Main_menu_page,small_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            intent.putExtra("cnt4",cnt)
            startActivity(intent)
        }
        //요거트
        btn_small_menu_page5.setOnClickListener{
            cnt = "요거트 메뉴를 선택하셨습니다. 딸기요거트는 1번. 블루베리요거트는 2번"
            voice = cnt
          //  cnt = "딸기요거트. 차갑게 드실려면 1번.따뜻하게 드실려면2번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this@Main_menu_page,small_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            intent.putExtra("cnt5",cnt)
            startActivity(intent)
        }
        //디저트
        btn_small_menu_page6.setOnClickListener{
            cnt= "디저트 메뉴를 선택하셨습니다. 케이크는 1번. 류승주는 2번"
            voice = cnt
           // cnt = "보리차. 차갑게 드실려면 1번.따뜻하게 드실려면2번"
            if(voice != null){
                Log.d("TAG", "onCreate: 음성출력")
                ttsSpeak(voice!!)
            }
            val intent = Intent(this@Main_menu_page,small_menu_page::class.java)
            intent.putExtra("매장명",user_shop_name)
            intent.putExtra("먹포",eat)
            intent.putExtra("cnt6",cnt)
            startActivity(intent)
        }

        //customer 에서 넘어온 음성 값
       //  a = intent.getStringExtra("음성")!!
        //음성 출력
//        val intent : Intent = Intent()
//        intent.action = TextToSpeech.Engine.ACTION_CHECK_TTS_DATA
//        activityResult.launch(intent)
//        Log.d("음성 값",a)

    }
    //음성 함수
    private fun initTextToSpeech(){
        Log.d("tag", "initTextToSpeech: 함수실행")
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
            return
        }
        tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
            if(it == TextToSpeech.SUCCESS){
                var result = tts?.setLanguage(Locale.KOREA)
                if(result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                    return@OnInitListener
                }
            }
        })
    }
    private fun ttsSpeak(text : String){
        tts?.speak(text,TextToSpeech.QUEUE_ADD, null, null)
    }

//    private  val activityResult: ActivityResultLauncher<Intent> = registerForActivityResult(
//        ActivityResultContracts.StartActivityForResult()){
//        if(it.resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS){
//            //음성전환 준비
//            textToSpeech = TextToSpeech(this, this)
//        }else{//없다면 다운로드
//            //데이터 다운로드
//            val installIntent : Intent = Intent()
//            installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
//            startActivity(installIntent)
//        }
//    }
    //textToSpeech 엔진 초기화시 호출되는 함수
//    override fun onInit(status: Int) {
//        if(status== TextToSpeech.SUCCESS){
//            //언어 값
//            val languageStatus : Int = textToSpeech.setLanguage(Locale.KOREA)
//
//            //데이터 문제 없거나 지원할수 없으면
//            if(languageStatus == TextToSpeech.LANG_MISSING_DATA ||
//                languageStatus == TextToSpeech.LANG_NOT_SUPPORTED) {
//                Toast.makeText(this, "언어를 지원 x", Toast.LENGTH_LONG).show()
//            }else{//데이터 성공
//                //입력값 변수에 담기
//                val data :String = a
//
//                var speechStatus : Int = 0
//                //안드로이드 버전에 따른 조건 롤리팝보다 같거나 높다면
//                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
//                    speechStatus=textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH,null,null)
//                }else{
//                    speechStatus=textToSpeech.speak(data, TextToSpeech.QUEUE_FLUSH,null)
//                }
//
//                if(speechStatus== TextToSpeech.ERROR){
//                    Toast.makeText(this,"음성전환 에러 " , Toast.LENGTH_LONG).show()
//                }
//            }
//        }else {//실패
//            Toast.makeText(this,"음성전환 에러 " , Toast.LENGTH_LONG).show()
//        }
//
//
//    }


}