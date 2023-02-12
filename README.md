# calc

This program will give and API name `/calc` which will act both for `GET` and `POST` request.

## Usage
`POST` request:
```
❯ http POST :3000/calc expression="1 * 2 * ( 3 + 4 * ( 5 - 7 ) ) * ( 4 - 9.3 )"
HTTP/1.1 200 OK
Content-Length: 28
Content-Type: application/json;charset=utf-8
Date: Sun, 12 Feb 2023 09:26:58 GMT
Server: Jetty(9.4.48.v20220622)

{
    "result": 53.00000000000001
}

❯ http POST :3000/calc expression="1 * 2 * ( 3.5 + 4 * ( 5 - 7 ) ) * ( 4 - 9.3 )"
HTTP/1.1 200 OK
Content-Length: 15
Content-Type: application/json;charset=utf-8
Date: Sun, 12 Feb 2023 09:26:45 GMT
Server: Jetty(9.4.48.v20220622)

{
    "result": 47.7
}

❯ http POST :3000/calc expression="1 * 2 * ( 3 + 4 * ( 5.07 - 7.98 ) ) * ( 4 - 9.99 )"
HTTP/1.1 200 OK
Content-Length: 29
Content-Type: application/json;charset=utf-8
Date: Sun, 12 Feb 2023 09:26:24 GMT
Server: Jetty(9.4.48.v20220622)

{
    "result": 103.50720000000001
}
```

`GET` request:
```
❯ http GET :3000/calc
HTTP/1.1 200 OK
Content-Length: 367
Content-Type: application/json;charset=utf-8
Date: Sun, 12 Feb 2023 09:27:26 GMT
Server: Jetty(9.4.48.v20220622)

{
    "8cc933f70523a394368c614007533b7d": {
        "expression": "1 * 2 * ( 3.5 + 4 * ( 5 - 7 ) ) * ( 4 - 9.3 )",
        "result": 47.7
    },
    "b23b249379469fc4b4663626d19a8f2e": {
        "expression": "1 * 2 * ( 3 + 4 * ( 5 - 7 ) ) * ( 4 - 9.3 )",
        "result": 53.00000000000001
    },
    "f23421f5437563aede616be08de76dd5": {
        "expression": "1 * 2 * ( 3 + 4 * ( 5.07 - 7.98 ) ) * ( 4 - 9.99 )",
        "result": 103.50720000000001
    }
}
```
## License

Copyright © 2023 Khan Mohammad R.

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
