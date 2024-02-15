package ru.netology.nmedia.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.dto.function

class PostRepositoryInMemoryImpl : PostRepository {
    private var nextId = 1L
    private var posts = listOf(
        Post(
        id = nextId++,
        author = "Нетология. Университет интернет-профессий будущего",
        content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        published = "21 мая в 18:36",
        likeByMe = false,
        likes = 999,
        shares = 999,
        shareByMe = false,
        view = 9


    ),
            Post(
                id = nextId++,
                author = "Нетология. Университет интернет-профессий будущего",
                content = "Жди меня, и я вернусь.\n" +
                        "Только очень жди,\n" +
                        "Жди, когда наводят грусть\n" +
                        "Желтые дожди,\n" +
                        "Жди, когда снега метут,\n" +
                        "Жди, когда жара,\n" +
                        "Жди, когда других не ждут,\n" +
                        "Позабыв вчера.\n" +
                        "Жди, когда из дальних мест\n" +
                        "Писем не придет,\n" +
                        "Жди, когда уж надоест\n" +
                        "Всем, кто вместе ждет.\n" +
                        "Жди меня, и я вернусь,\n" +
                        "Не желай добра\n" +
                        "Всем, кто знает наизусть,\n" +
                        "Что забыть пора.\n" +
                        "Пусть поверят сын и мать\n" +
                        "В то, что нет меня,\n" +
                        "Пусть друзья устанут ждать,\n" +
                        "Сядут у огня,\n" +
                        "Выпьют горькое вино\n" +
                        "На помин души…\n" +
                        "Жди. И с ними заодно\n" +
                        "Выпить не спеши.\n" +
                        "Жди меня, и я вернусь,\n" +
                        "Всем смертям назло.\n" +
                        "Кто не ждал меня, тот пусть\n" +
                        "Скажет: — Повезло.\n" +
                        "Не понять, не ждавшим им,\n" +
                        "Как среди огня\n" +
                        "Ожиданием своим\n" +
                        "Ты спасла меня.\n" +
                        "Как я выжил, будем знать\n" +
                        "Только мы с тобой, —\n" +
                        "Просто ты умела ждать,\n" +
                        "Как никто другой.\n" +
                        "1941 г. Константин Симонов",
                published = "18 сенятбря в 10:12",
                likeByMe = false,
                likes = 10,
                shares = 10,
                shareByMe = false,
                view = 11

            ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Во дни сомнений, во дни тягостных раздумий о судьбах моей родины, — ты один мне поддержка и опора, о великий, могучий, правдивый и свободный русский язык! Не будь тебя — как не впасть в отчаяние при виде всего, что совершается дома? Но нельзя верить, чтобы такой язык не был дан великому народу!\nИван Тургенев. 1882г.",
            published = "30 июня в 17:23",
            likeByMe = false,
            likes = 1500,
            shares = 1500,
            shareByMe = false,
            view = 1500


        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Мужество\n" +
                    "\n" +
                    "Мы знаем, что ныне лежит на весах\n" +
                    "И что совершается ныне.\n" +
                    "Час мужества пробил на наших часах,\n" +
                    "И мужество нас не покинет.\n" +
                    "Не страшно под пулями мертвыми лечь,\n" +
                    "Не горько остаться без крова,\n" +
                    "И мы сохраним тебя, русская речь,\n" +
                    "Великое русское слово.\n" +
                    "Свободным и чистым тебя пронесем,\n" +
                    "И внукам дадим, и от плена спасем\n" +
                    "Навеки.\n" +
                    "1942 г. Анна Ахматова",
            published = "5 сентября в 12:29",
            likeByMe = false,
            likes = 15372,
            shares = 1278,
            shareByMe = false,
            view = 987

        ),
        Post(
            id = nextId++,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Клеветникам России\n" +
                    "\n" +
                    "О чем шумите вы, народные витии?\n" +
                    "Зачем анафемой грозите вы России?\n" +
                    "Что возмутило вас? волнения Литвы?\n" +
                    "Оставьте: это спор славян между собою,\n" +
                    "Домашний, старый спор, уж взвешенный судьбою,\n" +
                    "Вопрос, которого не разрешите вы.\n" +
                    "Уже давно между собою\n" +
                    "Враждуют эти племена;\n" +
                    "Не раз клонилась под грозою\n" +
                    "То их, то наша сторона.\n" +
                    "Кто устоит в неравном споре:\n" +
                    "Кичливый лях, иль верный росс?\n" +
                    "Славянские ль ручьи сольются в русском море?\n" +
                    "Оно ль иссякнет? вот вопрос.\n" +
                    "Оставьте нас: вы не читали\n" +
                    "Сии кровавые скрижали;\n" +
                    "Вам непонятна, вам чужда\n" +
                    "Сия семейная вражда;\n" +
                    "Для вас безмолвны Кремль и Прага;\n" +
                    "Бессмысленно прельщает вас\n" +
                    "Борьбы отчаянной отвага —\n" +
                    "И ненавидите вы нас…\n" +
                    "За что ж? ответствуйте: за то ли,\n" +
                    "Что на развалинах пылающей Москвы\n" +
                    "Мы не признали наглой воли\n" +
                    "Того, под кем дрожали вы?\n" +
                    "За то ль, что в бездну повалили\n" +
                    "Мы тяготеющий над царствами кумир\n" +
                    "И нашей кровью искупили\n" +
                    "Европы вольность, честь и мир?..\n" +
                    "Вы грозны на словах — попробуйте на деле!\n" +
                    "Иль старый богатырь, покойный на постеле,\n" +
                    "Не в силах завинтить свой измаильский штык?\n" +
                    "Иль русского царя уже бессильно слово?\n" +
                    "Иль нам с Европой спорить ново?\n" +
                    "Иль русский от побед отвык?\n" +
                    "Иль мало нас? Или от Перми до Тавриды,\n" +
                    "От финских хладных скал до пламенной Колхиды,\n" +
                    "От потрясенного Кремля\n" +
                    "До стен недвижного Китая,\n" +
                    "Стальной щетиною сверкая,\n" +
                    "Не встанет русская земля?..\n" +
                    "Так высылайте ж к нам, витии,\n" +
                    "Своих озлобленных сынов:\n" +
                    "Есть место им в полях России,\n" +
                    "Среди нечуждых им гробов.\n" +
                    "1831 г. Александр Пушкин",
            published = "3 февраля 19:52",
            likeByMe = false,
            likes = 1524598,
            shares = 12570,
            shareByMe = false,
            view = 15652345
        )
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data

    override fun likeById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(likeByMe = !it.likeByMe, likes = if (it.likeByMe) it.likes -1 else it.likes +1)

        }
        data.value = posts
    }
    override fun shareById(id: Long){
        posts = posts.map {
            if (it.id !=id) it else it.copy(shareByMe = !it.shareByMe, shares = if (it.shareByMe) it.shares +1 else it.shares +1)
        }
        data.value = posts
    }

    override fun removebyId(id: Long) {
        posts = posts.filter { it.id != id }
        data.value = posts
    }

    override fun save(post: Post) {
        posts = if (post.id == 0L) {
             listOf(post.copy(id = nextId++, published = "now", author = "Netology")) + posts
        }else {
            posts.map {
                if (it.id != post.id) it else it.copy(content = post.content)
            }
        }
        data.value = posts
    }

}