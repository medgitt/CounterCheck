# CounterCheck
CRUD Operation_CodeTest(AssaBloy)

Sample API Response

1. Create new Counter(s)

POST API: 

URL:

http://localhost:9494/api/counter/create_counter

Body:
{"counterName": "Medha",
"incrementValue" : 5
}


Sample Response:

{
    "code": 201,
    "status": "success",
    "message": "Medha counter is successfully created."
}

2. Increment a named counter by 1

PUT API:

a) Increments By 1 based on Counter_Name

URL:
http://localhost:9494/api/counter/update_counter/Medha

Response:
{
    "code": 200,
    "status": "success",
    "message": "Medha counter is successfully updated."
}

b) Increments by 1 based on JSON BodyRequest

URL:
http://localhost:9494/api/counter/update_counter

body: 
{"counterName": "Medha"}

Response:
{
    "code": 200,
    "status": "success",
    "message": "Medha counter is successfully updated."
}

c) Increments the value passed by the user which is in JSON BodyRequest 

URL:
http://localhost:9494/api/counter/update_counter

body:
{"counterName": "Medha",
"incrementValue" : 7
}


Response:
{
    "code": 200,
    "status": "success",
    "message": "Medha counter is successfully updated."
}

3. Get a current value of a counter

GET API:

URL:
http://localhost:9494/api/counter/get_value_by_counter/Medha

Response:
{
    "code": 200,
    "status": "success",
    "message": "Successfully fetched all values of Medha",
    "data": [
        {
            "id": 1,
            "counterName": "Medha",
            "incrementValue": 14,
            "createdAt": "2022-05-10T09:04:13.000+00:00",
            "updatedAt": "2022-05-10T09:04:13.000+00:00"
        }
    ]
}

4. Get a list of all counters and their current values

GET API:
 
URL:
http://localhost:9494/api/counter/get_all_counters

Response:
{
    "code": 200,
    "status": "success",
    "message": "Successfully fetched all values",
    "data": [
        {
            "id": 1,
            "counterName": "Sample",
            "incrementValue": 1,
            "createdAt": "2022-05-10T09:04:13.000+00:00",
            "updatedAt": "2022-05-10T09:04:13.000+00:00"
        },
        {
            "id": 2,
            "counterName": "Test",
            "incrementValue": 1,
            "createdAt": "2022-05-10T09:04:14.000+00:00",
            "updatedAt": "2022-05-10T09:04:14.000+00:00"
        },
        {
            "id": 3,
            "counterName": "Duri",
            "incrementValue": 4,
            "createdAt": "2022-05-10T09:16:34.000+00:00",
            "updatedAt": "2022-05-10T09:16:34.000+00:00"
        },
        {
            "id": 4,
            "counterName": "Medha",
            "incrementValue": 14,
            "createdAt": "2022-05-10T09:18:13.000+00:00",
            "updatedAt": "2022-05-10T09:29:07.000+00:00"
        }
    ]
}

5. Delete a counter

DELETE API:

URL:
http://localhost:9494/api/counter/delete_counter/Medha

Response:
{
    "code": 200,
    "status": "success",
    "message": "Medha counter is successfully deleted."
}



Error Response:
{
    "description": "404 NOT_FOUND",
    "message": "Could not find a counter Medha.",
    "status": "error"
}
