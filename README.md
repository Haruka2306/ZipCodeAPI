## 外部APIへアクセスして住所を取得
### 概要
#### 仕様：郵便番号検索APIにアクセスし、address1～3, kana1～3を取得する
### 動作確認
Postman URL：```http://localhost:8080/address?zipcode=1000011```<br>
status code：200OK
![task10-ZipCode-200](https://github.com/Haruka2306/ZipCodeAPI/assets/137120436/02172a01-df8e-467a-b3b8-2f312fc5d79a)

★不正な郵便番号が入力された場合<br>
Postman URL：```http://localhost:8080/address?zipcode=100001```<br>
status code：200OK
![task10-ZipCode-400](https://github.com/Haruka2306/ZipCodeAPI/assets/137120436/2ed73e59-99d2-4c28-a891-dfead7abeb1d)
