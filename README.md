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

★バリデーションを実装し、自作したエラーレスポンスを返す
* zipcodeが未入力、入力されたzipcodeが不適切の場合に、400 BadRequestを返す

Postman URL：```http://localhost:8080/address?zipcode=```、```http://localhost:8080/address?zipcode=abcdefg```

| 項目 | レスポンス|
| ---- | ----- |
| HTTP status code| 400 |
| path | /address |
| error | Bad Request |
| message | ZipCode entered is incorrect |

![task10-zipcode-validation400-2](https://github.com/Haruka2306/ZipCodeAPI/assets/137120436/9c7029a9-01bf-4a69-a2fa-ecdf28692a20)

![task10-zippcode-validation400](https://github.com/Haruka2306/ZipCodeAPI/assets/137120436/50ef1813-340f-49cb-8a05-a33b9a2f8be6)
