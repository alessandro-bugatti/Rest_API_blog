# Rest_API_blog
## How to use REST API in Java, a simple example

This example shows how to connect to a REST API endpoint to get information about a blog. Inside the blog there are articles and the application retrieve information about them using *HTTPURLConnection* and the JSON library to parse data.
The REST API service must run on the same machine to use the code without any modifications or on the web, but in this case it is needed to modify the URL.

## The REST API
Here a brief description of the blog REST API

## ARTICLE
### GET /articles
#### Descrizione
> Return the list of all articles
#### JSON
> An array containing one JSON object for each article
##### Example
    [
      {"id":"1","title":"Brilliance","text":"A good book","creation_date":"2016-04-27"},
      {"id":"2","title":"Pilgrim","text":"Another good book","creation_date":"2016-04-28"}
    ]
#### HTTP code
> 200 
