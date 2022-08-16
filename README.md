# HW 0812
## 請在 Postman 導入 {JPA訂單系統.postman_collection.json} 測試 API

## 請用外部連結導入 H2 DB

* 導入可參考[這篇文章](https://stackoverflow.com/questions/43256295/how-to-access-in-memory-h2-database-of-one-spring-boot-application-from-another/43276769#43276769)

1. 
![](https://i.imgur.com/AaCNN9U.png)

2. 設定 URL 為: 
```
jdbc:h2:tcp://localhost:9092/mem:training

帳號：sa
密碼：123
```
![](https://i.imgur.com/Nl187WD.png)


3. 如果要跳過設定，將 ZIP 拉到桌面，直接解壓縮 ZIP 檔，拉進 IntelliJ IDEA，這樣啟動專案 H2 DB 不用重新連線！

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
4. 請使用 getAllOrders 查詢全部的訂單
5. 請使用 getOrderById 查詢全部的訂單

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
