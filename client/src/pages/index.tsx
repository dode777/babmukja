import { useEffect } from 'react';
import { useDispatch } from 'react-redux';

import { useRootState } from '@/hooks/useRootState';
import { loadPostsRequest } from '@/reducers/post/getAllPosts';

interface homeProps {}

const Home: React.FC<homeProps> = ({}) => {
  const dispatch = useDispatch();
  const { allPosts } = useRootState((state) => state.post);

  useEffect(() => {
    dispatch(loadPostsRequest());
  }, [dispatch]);

  console.log(allPosts);

  return <div>test</div>;
};

export default Home;
