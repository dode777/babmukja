// sginup, signin, logout example
export const LOADING_SIGNUP_SUBMIT = 'LOADING_SIGNUP_SUBMIT' as const;
export const LOADING_SIGNIN_SUBMIT = 'LOADING_SIGNIN_SUBMIT' as const;
export const LOADING_LOGOUT = 'LOADING_LOGOUT' as const;

// is loading
export const LOADING_POSTS = 'LOADING_POST' as const;

export type loadingType = typeof LOADING_POSTS;
