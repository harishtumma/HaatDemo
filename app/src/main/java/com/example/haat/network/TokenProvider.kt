package com.example.haat.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenProvider @Inject constructor() {
        fun getToken(): String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJlMWZiMTdlMC0yNWU2LTQ4MDktYWU3MS1jZTNmYmY2NTA1YmEiLCJqdGkiOiIzZjY2NWI1Zi0yNDMyLTQzOGItOGI5Yy03NjI4ZDA5ZGNjY2UiLCJleHAiOjE5MTMxOTkxMDgsImF1ZCI6Imh0dHBzOi8vdXNlci1hcHAtc3RhZ2luZy5pbnRlcm5hbC5oYWF0LmRlbGl2ZXJ5In0.HlktNCG7VjgnJxum5uIITVhHME8XhGya8nuOwzt3BEw"
}
