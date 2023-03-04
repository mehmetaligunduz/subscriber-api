# subscriber-study-case
Bu proje abone(subscriber) bilgilerinin in memory cache üzerinde tutulup ilgili data manipulasyonlarının cache üzerinde gerçekleştirilmesini, cache üzerinde tutulan datanın belirli zaman aralıklarında kaydedilmesi ve uygulamanın kapatılması yada crash olması durumunda bu bilgilerin **data.json** dosyasına kaydedilmesini amaçlamaktadır. Uygulama **:8080** portunu dinlemektedir. Data dosyası(data.json) pathi, schedulera ait cron expression bilgisi ve logginge ait format düzenlemesi **application.yaml** dosyasından okunmaktadır.

**Application.yaml**
```
server:
  port: 8080

data:
  data_file_path: src/main/resources/data.json

schedule:
  cron: 0 0/30 * * * * # run at every 30 minute

logging:
  pattern:
    file: "%m%n"

```

Uygulamada default olarak 30 dakikada bir cache üzerindeki bilgiler ```src/main/resources/data.json``` dosyasına yazılmaktadır. Verileri kaydetme aralığında yada verilerin okunup, yazılacağı dosyada değişiklik yapılmak istendiğinde ilgili değişiklikler **application.yaml** üzerinden yapılmalıdır.

## Rest Services ##
+ **/subscriber ```POST```**

/subscriber enpointine yapılacak ```POST``` isteklerinde subscriber kaydı yapılmaktadır. İstek gövdesinde id, name, msisdn değerleri alınmaktadır. Id unique değerdir aynı id'ye sahip subscriber olamaz. Varolan bir id ile subscriber kaydı yapılması durumunda **IdAlreadyExitException** hatası fırlatılır.

**cURL**
```
curl --location 'localhost:8080/subscriber' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "id": "1",
    "name": "Linus Torvalds",
    "msisdn": "905558887965" 
}'
```

+ **/subscriber ```PUT```**

/subscriber enpointine yapılacak ```PUT``` isteklerinde subscriber güncelleme işlemi gerçekleştirilmektedir.İstek gövdesinde id, name, msisdn değerleri alınmaktadır. Güncellenmek istenilen id ile kullanıcı bulunamaz ise **SubscriberNotFoundException** hatası fırlatılmaktadır.

**cURL**
```
curl --location --request PUT 'localhost:8080/subscriber' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
    "id": "1",
    "name": "Steve Jobs",
    "msisdn": "0014083424567" 
}'
```

+ **/subscriber ```DELETE```**

/subscriber enpointine yapılacak ```DELETE``` isteklerinde subscriber silme işlemi gerçekleştirilmektedir. İstek gövdesinde id değeri alınmaktadır. Silmek istenilen id ile kullanıcı bulunamaz ise **SubscriberNotFoundException** hatası fırlatılmaktadır.

**cURL**
```
curl --location --request DELETE 'localhost:8080/subscriber' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{
     "id": "1"
}'
```

## SOAP Services ##
+ **/getAllSubscribers**
+ **/getSubscriberById/{Id}**

# Nasıl Çalışır?

# Postman Collection
Yukarıda detayları paylaşılan REST ve SOAP servislere ait postman collection oluşturulmuştur. **Postman Collection** bağlantısından ulaşabilirsiniz. Collectionları Postman'e import edip request-response yapısını inceleyebilirsiniz.
[Postman Collection](https://api.postman.com/collections/21282248-61b36244-6e42-45d5-9867-686b6f04d275?access_key=PMAT-01GTQ7HDYZA55CJY7DKPBE3EJP)
