import { IResponsePosts } from '@/types/post';

export const LOAD_POSTS_REQUEST = 'LOAD_POSTS_REQUEST' as const;
export const LOAD_POSTS_SUCCESS = 'LOAD_POSTS_SUCCESS' as const;
export const LOAD_POSTS_FAILURE = 'LOAD_POSTS_FAILURE' as const;

export interface LoadPostsRequest {
  type: typeof LOAD_POSTS_REQUEST;
}

export interface LoadPostsSuccess {
  type: typeof LOAD_POSTS_SUCCESS;
  data: IResponsePosts[];
}

export interface LoadPostsFailure {
  type: typeof LOAD_POSTS_FAILURE;
  error: string;
}

export const loadPostsRequest = (): LoadPostsRequest => ({
  type: LOAD_POSTS_REQUEST,
});

export const loadPostsSuccess = (data: IResponsePosts[]): LoadPostsSuccess => ({
  type: LOAD_POSTS_SUCCESS,
  data,
});

export const loadPostsFailure = (error: string): LoadPostsFailure => ({
  type: LOAD_POSTS_FAILURE,
  error,
});

export type GetAllPost =
  | ReturnType<typeof loadPostsRequest>
  | ReturnType<typeof loadPostsSuccess>
  | ReturnType<typeof loadPostsFailure>;
