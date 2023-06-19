package com.example.lab6;

import com.yandex.mapkit.geometry.Point;

import java.util.List;

public class Base
{
    public static final List<Sight> sights = List.of(
            new Sight("Большой театр","Государственный академический Большой театр России, " +
                    "Большой театр России или просто Большой театр — один из крупнейших в России" +
                    " и один из самых значительных в мире театров оперы и балета. Комплекс зданий театра " +
                    "расположен в центре Москвы, на Театральной площади", new Point(55.760012746906185,37.61908848090184),"",100 ),
            new Sight("Кремль","Кремль (детинец, кром) — название городских укреплений в древней Руси; город, окружённый крепостной стеной с " +
                    "бойницами и башнями (см. список известных кремлей). Кремль — метоним, принятый в общественно-публицистической лексике для обозначения " +
                    "высших кругов власти СССР и Российской Федерации.", new Point(55.75208673758386,37.61746607091341),"",200),
            new Sight("ВДНХ","Выставка достижений народного хозяйства — это крупнейший многофункциональный выставочно-конгрессный и рекреационный" +
                    " комплекс Москвы, занимающий территорию более 235 гектаров. Ежегодно его посещают свыше 20 миллионов москвичей и гостей столицы.   " +
                    "Источник — kudamoscow.ru, лучшие события Москвы.", new Point(55.83024627713773,37.6310270281309),"",300),
            new Sight("Парк Горького","Центральный парк культуры и отдыха имени Горького – один из главных парков Москвы, который ежедневно посещают десятки тысяч " +
                    "человек. Он стал первым парком мирового уровня в России, пространством для отдыха, спорта, танцев и игр на свежем воздухе.   Источник — kudamoscow.ru, " +
                    "лучшие события Москвы.", new Point(55.73106030731547,37.602972222239636),"",400 ),
            new Sight("Москва сити","Московский деловой центр «Москва-Сити» — ультрасовременный архитектурный комплекс небоскребов из " +
                    "стекла и бетона высотой от 27 до 96 этажей. Это «город будущего» посреди столицы, расположенный на Краснопресненской " +
                    "набережной, в излучине Москвы-реки, в 4 км от кремля. Архитектура зданий сочетает в себе модерн, хай-тек и неоконструктивизм. " +
                    "Москвичи приезжают сюда на работу, за покупками и развлечениями, а гости — на выставки, обзорные экскурсии и шоппинг.",
                    new Point(55.74913580836923, 37.53829270521656 ), "8:00-21:00",500 ),
            new Sight("Третьяковская галерея","",new Point(55.7413603,37.6207888),"10:00-20:00",400),
            new Sight("Воробьевы горы","",new Point(55.7100618,37.5432298),""),
            new Sight("Останкинская телебашня","",new Point(55.819682,37.611663),"9:00-22:00",300),
            new Sight("Коломенское","",new Point(55.668056,37.669444),"",200),
            new Sight("Государственный исторический музей","",new Point(55.75509,37.61759),"10:00-20:00",100),
            new Sight("Донской монастырь","",new Point(55.714245, 37.599871),"",200),
            new Sight("Никольская улица","",new Point(55.757126, 37.622432),"",0)
    );
}