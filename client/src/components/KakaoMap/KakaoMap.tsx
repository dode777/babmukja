import React, { forwardRef, Ref } from 'react';

interface KakaoMapProps {
  ref: Ref<HTMLDivElement>;
}

const KakaoMap: React.FC<KakaoMapProps> = forwardRef((_props, ref) => {
  return (
    <div style={{ width: '100%', height: '100%' }}>
      <div ref={ref} style={{ width: '100%', height: '100%' }} />
    </div>
  );
});

KakaoMap.displayName = 'KakaoMap';

export default React.memo(KakaoMap);
