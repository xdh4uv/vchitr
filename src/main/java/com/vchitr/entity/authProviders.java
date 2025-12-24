package com.vchitr.entity;


/**
 * enums to define authProvider
 * each user must be linked to an auth provider
 * LOCAL auth provider -> user using email to login into our system directly
 * GOOGLE -> users authorized after logging from google
 * authProviders
*/

public enum authProviders {
    LOCAL,
    GOOGLE
}
