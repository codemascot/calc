# calc

This program will give and API name `/calc` which will act both for `GET` and `POST` request.

## Installation

Download from http://example.com/FIXME.

## Usage
`POST` request:
```
❯ http POST :3000/calc expression="1 * 2 * ( 3 + 4 * ( 5 - 7 ) ) * ( 4 - 9 )"
HTTP/1.1 200 OK
Content-Length: 13
Content-Type: application/json;charset=utf-8
Date: Sat, 11 Feb 2023 21:23:18 GMT
Server: Jetty(9.4.48.v20220622)

{
    "result": 50
}
```

`GET` request:
```
❯ http GET :3000/calc expression="1 * 2 * ( 3.5 + 4 * ( 5 - 7 ) ) * ( 4 - 9.3 )"
HTTP/1.1 200 OK
Content-Length: 174
Content-Type: application/json;charset=utf-8
Date: Sat, 11 Feb 2023 21:23:04 GMT
Server: Jetty(9.4.48.v20220622)

{
    "-962731914": {
        "expression": "1 * 2 * ( 3 + 4 * ( 5 - 7 ) ) * ( 4 - 9 )",
        "result": 50
    },
    "804367688": {
        "expression": "1 * 2 * ( 3.5 + 4 * ( 5 - 7 ) ) * ( 4 - 9.3 )",
        "result": 47.7
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
