org.springframework.cloud.contract.spec.Contract.make {
    description("""
Represents a successful scenario of getting a loan

```
given:
	List of alerts
when:
	user reqeusts alerts
then:
	we'll grant her the loan
```

    """)
    request {
        method GET()
        url "/getAll"
    }
    response {
        status 200
        body("""
            {"alerts":[{"app":"app","category":"category","message":"message"}]}
        """)
        headers {
            contentType(applicationJson())
        }
    }
}
