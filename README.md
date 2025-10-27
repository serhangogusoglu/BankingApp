                                                         🏦 Mobile Bankacılık Prototipi (Kotlin & Dark Mode)

Bu proje, modern bir mobil bankacılık deneyimini simüle etmek amacıyla Kotlin dilinde geliştirilmiş bir Android uygulaması prototipidir. Kullanıcı dostu arayüzü, zengin finansal takip özellikleri ve güçlü yerelleştirme (localization) desteği ile öne çıkmaktadır.

✨ Uygulamanın Öne Çıkan Özellikleri
Uygulama, temel bankacılık ve kişisel finans yönetimi işlevlerini modern bir tasarımla birleştirir.

1. Kullanıcı ve Güvenlik Yönetimi
Giriş Öncesi Tanıtım (Onboarding): Uygulamanın temel faydalarını ve hızını tanıtan şık bir karşılama serisi. (Bkz: onboarding1.png)
Güvenli Oturum: Giriş (Sign In) ve Kayıt (Sign Up) ekranları ile kullanıcı kimlik doğrulaması.
Doğrulama (Validation): Kayıt sırasında e-posta, telefon numarası ve şifre için gerekli alan doğrulama uyarıları (signupalert.png).

Güvenlik Ayarları: 
Biyometrik Kimlik Doğrulama: Ayarlar sayfasından kolayca etkinleştirilip devre dışı bırakılabilen ek güvenlik katmanı.
Şifre Değiştirme: Kullanıcıların mevcut ve yeni şifrelerini girerek hesap güvenliğini yönetebileceği ekran. (sifredegistirekrani.png)
Gizlilik: Kullanıcı verilerinin (e-posta, şifre, telefon no vb.) yerel olarak (SharedPreferences kullanılarak) saklandığını belirten detaylı Gizlilik Politikası ekranı.

2. Finansal İşlemler ve Yönetim
Ana Sayfa (Home): Kişiselleştirilmiş karşılama ve kullanıcı profili önizlemesi. Kartın temel bilgilerini (Kart No, CVV, Son Kullanma Tarihi) gösteren modern bir önizleme kartı.
Hızlı İşlemler: Gönder (Sent), Al (Receive), Kredi (Loan), Yükleme (Topup) gibi sık kullanılan aksiyonlar.
Son İşlemlerin listesi.

Kart Yönetimi (My Cards):
Karta ait harcama geçmişinin özeti.
Aylık Harcama Limiti: Kullanıcının harcama sınırını görselleştiren ve ayarlamasını sağlayan interaktif limit belirleme aracı.
İstatistik ve Takip (Statistics): Mevcut Bakiye'nin net gösterimi. Aylık harcama eğilimlerini gösteren görsel grafik. İşlemlerin kategori ve aya göre takip edilebildiği detaylı işlem geçmişi listesi.

3. Kullanıcı Arayüzü ve Yerelleştirme
Modern Koyu Tema (Dark Mode): Şık, minimalist ve göz yorgunluğunu azaltan koyu renk paleti.
Profil Detayları: Kişisel Bilgiler, Ödeme Tercihleri, Bankalar ve Kartlar, Bildirimler, Adres gibi alt menülerin bulunduğu kapsamlı Profil sayfası.

Çoklu Dil (Localization) Desteği: Ayarlar menüsü üzerinden değiştirilebilen 4 farklı dil desteği:
Türkçe
İngilizce (English)
Almanca (Deutsch)
Fransızca (Français)

💻 Kullanılan Teknolojiler
Dil: Kotlin
Platform: Android
Geliştirme Ortamı: Android Studio
UI/UX: XML Layouts ile oluşturulmuş, Material Design ilkelerine uygun arayüz.
Veri Depolama: SharedPreferences (Yerel kullanıcı ayarları, oturum bilgileri ve çoklu dil tercihlerinin kalıcı olarak saklanması için kullanılmıştır.)

<img width="403" height="826" alt="splashscreen" src="https://github.com/user-attachments/assets/6c02552f-b127-479e-977f-479d8a9a19e5" />
<img width="407" height="827" alt="onboarding1" src="https://github.com/user-attachments/assets/f92c6298-08d7-4c7b-a0da-3a35351447b0" />
<img width="409" height="806" alt="onboarding2" src="https://github.com/user-attachments/assets/e758b104-e73d-4032-a43e-12dbf4fed746" />
<img width="422" height="827" alt="onboarding3" src="https://github.com/user-attachments/assets/7278489b-dacb-4c71-a1c9-093146dc65c1" />
<img width="405" height="823" alt="signin" src="https://github.com/user-attachments/assets/4d03d19c-5686-42a5-ad8d-7a37a3a1d357" />
<img width="411" height="823" alt="signinalert" src="https://github.com/user-attachments/assets/76e76aa9-bce1-4779-b7a7-0432f1e92b8f" />
<img width="426" height="845" alt="nSignUpScreen" src="https://github.com/user-attachments/assets/de2fefc2-13b7-404b-8b2b-b815a955b7e1" />
<img width="410" height="841" alt="nSignupAlert" src="https://github.com/user-attachments/assets/fbe10d75-679d-46a0-95f0-c12f46163623" />
<img width="412" height="833" alt="homepagescreen" src="https://github.com/user-attachments/assets/38aadd66-5293-4dea-a4e6-8af1c697742d" />
<img width="435" height="823" alt="mycardsscreen" src="https://github.com/user-attachments/assets/7a1d72c5-478a-4145-8d2b-55851f4bc2ba" />
<img width="400" height="819" alt="statisticsscreen" src="https://github.com/user-attachments/assets/d81327f6-b940-4177-a450-226166dd3f36" />
<img width="413" height="817" alt="settingsscreen" src="https://github.com/user-attachments/assets/20a699a6-d7e1-43a0-853e-0c0fd4bc3e81" />
<img width="411" height="817" alt="settingscreenalert" src="https://github.com/user-attachments/assets/47508756-b0d3-4f67-bf82-9ae5a5c67565" />
<img width="395" height="810" alt="languagebottomsheet" src="https://github.com/user-attachments/assets/4a7172b8-f126-4949-a5b9-4c08432527ed" />
<img width="410" height="822" alt="gizlilikpolitikasiekrani" src="https://github.com/user-attachments/assets/64d5a42c-349d-4dcb-a3f3-bc40ad719d26" />
<img width="421" height="818" alt="sifredegistirekrani" src="https://github.com/user-attachments/assets/de266279-c318-4699-9579-d7d2542a5d2d" />
<img width="441" height="854" alt="nProfileScreen" src="https://github.com/user-attachments/assets/d8718500-3371-4e48-befc-b01a6d9fd591" />
<img width="407" height="818" alt="bizeulasinsayfasipng" src="https://github.com/user-attachments/assets/ddf4a5fb-c66e-4a80-b98d-b541ae2c9e91" />
