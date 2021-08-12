import produce from 'immer';
import { IResponsePosts } from '@/types/post';
import { loadingType, LOADING_POSTS } from './values';
import { LOAD_POSTS_REQUEST, LOAD_POSTS_SUCCESS, LOAD_POSTS_FAILURE, GetAllPost } from '@/reducers/post/getAllPosts';

interface IPoststate {
  allPosts: IResponsePosts[];
  isLoading: {
    id: number | null;
    name: loadingType | null;
  };
}

const postState: IPoststate = {
  allPosts: [],
  isLoading: {
    id: null,
    name: null,
  },
};

type ReducerAction = GetAllPost;

const posts = (state: IPoststate = postState, action: ReducerAction) => {
  return produce(state, (draft) => {
    switch (action.type) {
      case LOAD_POSTS_REQUEST:
        draft.isLoading.name = LOADING_POSTS;
        break;
      case LOAD_POSTS_SUCCESS:
        draft.isLoading.id = null;
        draft.isLoading.name = null;
        draft.allPosts = draft.allPosts.concat(action.data);
        break;
      case LOAD_POSTS_FAILURE:
        draft.isLoading.id = null;
        draft.isLoading.name = null;
        break;
    }
  });
};

export default posts;
