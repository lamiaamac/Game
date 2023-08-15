# Game
Siyah ve Beyaz taşların puanlarını bir satranç oyununun durum tablosundan hesaplayıp gösteren proje

Satranç Skor Hesaplama Uygulaması

Bu uygulama, bir satranç tahtasının verilerini (bilgileri içeren txt dosyasını) okuyarak taşların puanlarını hesaplar ve beyaz ile siyah oyuncuların skorlarını yazdırır. Uygulama, farklı taş türlerinin puanlama stratejilerini kullanarak skor hesaplamalarını gerçekleştirir.

Kullanım Kılavuzu
Bu bölümde, uygulamanın nasıl derleneceği ve kullanılacağı ayrıntılarıyla açıklanmıştır.

Ön Gereksinimler
Uygulamayı derlemek ve çalıştırmak için bilgisayarınızda aşağıdakilere ihtiyaç vardır:

Java Development Kit (JDK): Uygulamanın çalıştırılması için bir JDK gereklidir.
(Alternatif) Visual Studio Code : Bu editör kodun rahatça çalıştırılabilmesini sağlayacaktır.

Adım 1: Satranç Tahtası Dosyası Oluşturma
Satranç tahtasının bilgilerini içeren bir metin dosyası oluşturun (txt dosyası). Dosya formatı şu şekildedir:

pb sb -- -- -- -- -- -- 
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --
-- -- -- -- -- -- -- --

Örnek:
"p" bir piyonu ve "s" bir şahı temsil eder. "--" hücrede taş olmadığını gösterir.
"b" beyaz rengini, "s" siyah rengini temsil eder.

Dosya bir isimle kaydedilmelidir. Örneğin, board1.txt.

Adım 2: Uygulamanın Derlenmesi ve Çalıştırılması

Görüntülediğiniz Github repository'nin sağ üstünde "Code" yazan yeşil butonuna tıklayın.
"Download ZIP" seçeneğine tıklayın.
Dosyayı indirdikten sonra, ZIP halinde bulunan dosyanın içerisinden "Game" adlı dosyayı dışarı çıkartın.
Aşağıdaki adımları takip edin :

Terminal veya komut istemcisini açın ve kodun bulunduğu dizine gidin. Dizine gitmek için aşağıdaki komutu kullanabilirsiniz:

cd /path/to/your/code/folder

Kodunuzu derlemek için aşağıdaki komutu kullanın:

javac -d . services/*.java entities/*.java main/*.java

Derlendikten sonra uygulamanızı aşağıdaki komutla çalıştırabilirsiniz:

java main.App

Uygulama başladığında, satranç tahtası dosyasının adını girerek beyaz ve siyah oyuncuların skorlarını göreceksiniz.

Adım 2 (Alternatif)

İndirilen Visual Studio Code editörünü açın. Sol yukarıdaki sekmelerde "File" sekmesine basın. Açılan pencerede, "Open Folder" sekmesine basın ve "Game" adlı dosyayı seçin.

"Run" sekmesine basın ve açılan pencerede "Start Debugging" sekmesine basın. Eğer çalıştırılmazsa sağ yukarıda yan üçgen şeklindeki "Run" butonuna basın.

Açılan terminal çalıştıktan sonra (uygulama başladığında), dosya ismini (.txt olmadan) girerek sonucu alın.
