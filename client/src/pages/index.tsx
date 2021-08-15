import KakaoMap from '@/components/KakaoMap';
import { useKakaoMap } from '@/hooks/useKakaoMap';

interface homeProps {}

const Home: React.FC<homeProps> = ({}) => {
  const kakaoMap = useKakaoMap();

  return <KakaoMap ref={kakaoMap} />;
};

export default Home;
