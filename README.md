# HW 0812
## 請使用 API Tester 測試 API

連結：
https://chrome.google.com/webstore/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=zh-TW

加入擴充功能，並打開 API Tester
左下角 Import **JPA訂單系統.json**  就能 call API

![](https://i.imgur.com/tdC11GI.png)

## 請用外部連結導入 H2 DB

1. 
![](https://i.imgur.com/AaCNN9U.png)

2. 設定URL為: 
```
jdbc:h2:tcp://localhost:9092/mem:training

帳號：sa
密碼：123
```
![](https://i.imgur.com/Nl187WD.png)


3. 如果要跳過設定，可以直接解壓縮 ZIP 檔，拉進 IntelliJ IDEA

## API 簡介：

### API 流程：

1. Meal 的資料庫內已經 inser into 三筆資料，請進行增查改刪 Call API 並測試

2. Order 請先 post 一筆或多筆資料進去，請在 mealMap 內用以下 JSON 格式新增**資料庫內**餐點，以及你要新增餐點的數量，例：

* 可樂是**餐點**
* 數字 1 則為**數量**

```json=
{
"waiter": "Kz",
"mealMap" :
    {
    "可樂" : 1,
    "麥香魚" : 2,
    "辣味雞腿套餐" : 3
 	}
}
```
3. 如果要測試第四筆餐點，請先在 createMeal 新增一筆餐點的資料

### Meal

* 查詢所有的餐點：
    * getAllMeal : http://localhost:8080/meal
* 查詢特定餐點
    * getMealById : http://localhost:8080/meal/1
* 新增餐點
    * postMeal : http://localhost:8080/meal
* 修改餐點
    * updateMeal : http://localhost:8080/meal/1
* 刪除餐點
    *  deleMealById : http://localhost:8080/meal/2

### Order

* 查詢所有訂單
    * getAllOrders : http://localhost:8080/order
* 查詢特定訂單
    * getOrderById : http://localhost:8080/order/1
* 新增訂單
    * postOrder : http://localhost:8080/order

<details>
  
  <summary> ... </summary>
  

  ![](https://i.imgur.com/AV49ghA.jpg)
  
  ```
  Sometimes life hits you in the head with a brick. Don't lose faith.
  ```


</details>
