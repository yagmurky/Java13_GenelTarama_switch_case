package com.yagmur;

public class Runner_switch_case {
    public static void main(String[] args) {
        /**
         * Switch-case tanımı, if-else ile benzer bir şekilde bir variable’ın değerine göre
         * farklı kod bloklarının çalışmasını sağlar. Java 7’ye kadar switch-case tanımlamalarında
         * sadece integer değerde bir variable’ın koşulları kullanılabiliyorken,
         * Java 8’de String ve Enum type’lar için de kullanılabilir hale geldi.
         */

        //Java 8'den önce:

        int value = 1;
        switch (value){
            case 1:
                System.out.println("Bir seçildi.");
                break;
            case 2:
                System.out.println("İki seçildi.");
                break;
            case 3:
                System.out.println("Üç seçildi.");
                break;
            default:
                System.out.println("Geçersiz seçim.");
        }


        //Java 8 ile birlikte string ve enumlar için de kullanılabilir hale gelmiştir.

        //String
        String day= "Çarşamba";
        switch (day){
            case "Pazartesi":
                System.out.println("Haftanın 1. günü");
                break;
            case "Salı":
                System.out.println("Haftanın 2. günü");
                break;
            case "Çarşamba":
                System.out.println("Haftanın 3. günü");
                break;
            case "Perşembe":
                System.out.println("Haftanın 4. günü");
                break;
            case "Cuma":
                System.out.println("Haftanın 5. günü");
                break;
            case "Cumartesi":
                System.out.println("Haftanın 6. günü");
                break;
            case "Pazar":
                System.out.println("Haftanın 7. günü");
                break;
            default:
                System.out.println("Lütfen bir gün ismi giriniz.");
        }

        //enum

        Haftanin_Gunleri gun = Haftanin_Gunleri.Pazar;

        switch (gun){
            case Pazartesi:
                System.out.println("Haftanın 1. günü");
                break;
            case Sali:
                System.out.println("Haftanın 2. günü");
                break;
            case Carsamba:
                System.out.println("Haftanın 3. günü");
                break;
            case Persembe:
                System.out.println("Haftanın 4. günü");
                break;
            case Cuma:
                System.out.println("Haftanın 5. günü");
                break;
            case Cumartesi:
                System.out.println("Haftanın 6. günü");
                break;
            case Pazar:
                System.out.println("Haftanın 7. günü");
                break;
            default:
                System.out.println("Lütfen bir gün ismi giriniz.");
        }


        /**
         * Java 14 sonrasındaysa bir çok farklı kullanım şekli geldi.
         */

        /**
         * 1- Switch statemen’ı artık bir switch expression’a dönüştü. Yani assign edilebilen,
         * return edilebilen bir yapıya kavuştu. Fakat return edilecek ifadeden önce yield kullanılması gerekir
         */

        String donus=
        switch (day){
            case "Pazartesi":
                yield "Haftanın 1. günü";
            case "Salı":
                yield "Haftanın 2. günü";
            case "Çarşamba":
                yield "Güneşli bir gün.";
            case "Perşembe":
                yield "Haftanın 4. günü";
            case "Cuma":
                yield "Haftanın 5. günü";
            case "Cumartesi":
                yield "Haftanın 6. günü";
            case "Pazar":
                yield "Haftanın 7. günü";
            default:
                yield "Lütfen bir gün ismi giriniz.";
        };
        System.out.println(donus);


        /**
         * 2- case statement’ı arrow operator olarak tanımlanabilir hale geldi.
         * Yield yerine bu kullanım daha okunur olduğu için bu ifadenin tercih edilmesi daha faydalı olabilir:
         */

        String donus2= switch (day){
            case "Pazartesi" -> "Haftanın 1. günü";
            case "Salı" -> "Haftanın 2. günü";
            case "Çarşamba" -> "Güneşli bir gün.";
            case "Perşembe" -> "Haftanın 4. günü";
            case "Cuma" ->  "Haftanın 5. günü";
            case "Cumartesi" -> "Haftanın 6. günü";
            case "Pazar" -> "Haftanın 7. günü";
            default -> "Lütfen bir gün ismi giriniz.";
        };
        System.out.println(donus2);


        /**
         * 3- switch içinde yer alan değerin farklı case’leri için aynı işlem yapılabilmesini sağlamak için
         * tek bir case ifadesine farklı labellar yazılabilir hale geldi:
         */

        String ay = "OCAK";
        String mevsim = switch (ay) {
            case "ARALIK","OCAK","SUBAT" -> "Kış";
            case "MART","NISAN","MAYIS" -> "İlkbahar";
            case "HAZIRAN","TEMMUZ","ASUSTOS" -> "Yaz";
            case "EYLUL","EKIM","KASIM" -> "Sonbahar";
            default->"Ay adı giriniz.";
        };
        System.out.println(mevsim);


        /**
         * Java 17 sonrasında ise, yukarıdaki özelliklere ek olarak aşağıdaki özellikler geldi:
         *
         * 1- Pattern matching: (desen eşleme),
         * özellikle instanceof operatörü ile ilgili kod bloklarını daha temiz ve güvenli bir şekilde
         * yazmak için kullanılan bir dil özelliğidir. Bu özellikle daha önce instanceof ile bir nesnenin
         * türünü kontrol etmek ve ardından aynı nesneyi belirli bir türe dönüştürmek için yapılan yaygın
         * bir işlemi basitleştirir.
         */

        //oncesi

        Object o = 5;
        double result;
        if (o instanceof Integer) {
            result = ((Integer) o).doubleValue();
        } else if (o instanceof Float) {
            result = ((Float) o).doubleValue();
        } else if (o instanceof String) {
            result = Double.parseDouble(((String) o));
        } else {
            result = 0d;
        }
        System.out.println(result);


        //sonrası

        Object object = "2";
        Object sonuc = switch (object) {
            case Integer i -> i.doubleValue();
            case Float f -> f.toString();
            case String s -> Double.parseDouble(s);
            default -> 0d;
        };
        System.out.println(result);

        /**
         * Guarded Pattern (Korunan Desen), Java 17'de eklenen bir diğer desen eşleme (pattern matching) özelliğidir.
         * Bu özellik, instanceof operatörünü kullanırken bir türün özelliklerini kontrol etmenizi ve ardından
         * bu özelliklere dayanarak nesneyi daha güvenli bir şekilde kullanmanızı sağlar.
         */



        //oncesi

        Object o2 = "90";

        Object sonuc2 = switch (o2) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case String s -> {
                if (s.length() > 0) {
                    yield Double.parseDouble(s);
                } else {
                    yield 0d;
                }
            }
            default -> 0d;
        };

        System.out.println(sonuc2);

        Object o3= 10;
        Object sonuc3 = switch (o3) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            //case String s && (s.length() > 0 || s.length() < 5) -> {yield Double.parseDouble(s);}
            default -> 0d;
        };
        System.out.println(sonuc3);


        /**
         * 3-Null Cases: Java 17 öncesinde, switch-case’e geçmiş olduğunuz bir değerin asla
         * null olmaması gerekiyordu. Artık Java 17 ile birlikte bu kısıt kaldırıldı ve
         * null olması durumu case labelları ile ele alınabilir hale geldi:
         */

        Object o4 = null;

        Object sonuc4 = switch (o4) {
            case Integer i -> i.doubleValue();
            case Float f -> f.doubleValue();
            case null -> 0d;
            default -> 0d;
        };
        System.out.println(sonuc4);







    }
}
