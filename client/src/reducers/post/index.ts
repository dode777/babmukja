import produce from 'immer';
import { IResponsePosts } from '@/types/post';

import { LOAD_POSTS_REQUEST, LOAD_POSTS_SUCCESS, LOAD_POSTS_FAILURE, GetAllPost } from '@/reducers/post/getAllPosts';

interface IPoststate {
  allPosts: IResponsePosts[];
  loadPostsLoading: boolean;
  loadPostsDone: boolean;
  loadPostsError: string | null;
}

const postState: IPoststate = {
  allPosts: [],
  loadPostsLoading: false,
  loadPostsDone: false,
  loadPostsError: null,
};

type ReducerAction = GetAllPost;

const posts = (state: IPoststate = postState, action: ReducerAction) => {
  return produce(state, (draft) => {
    switch (action.type) {
      case LOAD_POSTS_REQUEST:
        draft.loadPostsLoading = true;
        draft.loadPostsDone = false;
        draft.loadPostsError = null;
        break;
      case LOAD_POSTS_SUCCESS:
        draft.loadPostsLoading = false;
        draft.loadPostsDone = true;
        draft.allPosts = draft.allPosts.concat(action.data);
        break;
      case LOAD_POSTS_FAILURE:
        draft.loadPostsLoading = false;
        draft.loadPostsError = action.error;
        break;
    }
  });
};

export default posts;
