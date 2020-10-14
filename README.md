# RegexValidator

END Point :: 
@PostMapping("/regex")

Data to be sent in JSON format inside request body as :

{
    "regex":"((0+)+y)",
    "requestBody":"kbfefejjjnjnjnj"
}

Responses are::

1.) Below is the response when both variables "regex" and "requestBody" are present as not-blank and not-null.

{
    "match": /*this will give matching first group*/,
    "error": /*this boolean will tell whether regex is errorneous or not.*/
}

2.) Below is the response that will receive in terms of list of errors as blank or null value received of any of the variable.

[
    "requestBody :: string to check must not be blank or null",
    "regex :: regex expression must not be blank or null"
]

