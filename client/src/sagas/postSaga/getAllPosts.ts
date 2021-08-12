import axios, { AxiosResponse } from 'axios';
import { call, put, takeLatest } from 'redux-saga/effects';

import { getPosts } from '@/api';
import { LOAD_POSTS_REQUEST, loadPostsSuccess, loadPostsFailure } from '@/reducers/post/getAllPosts';
import { IResponsePosts } from '@/types/post';

function loadArticlesAPI() {
  return axios.get(getPosts);
}

function* loadArticles() {
  try {
    const result: AxiosResponse<IResponsePosts[]> = yield call(loadArticlesAPI);
    yield put(loadPostsSuccess(result.data));
  } catch (err) {
    yield put(loadPostsFailure(err));
  }
}

function* watchLoadPosts() {
  yield takeLatest(LOAD_POSTS_REQUEST, loadArticles);
}

export default watchLoadPosts;
