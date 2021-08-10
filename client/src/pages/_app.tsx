import type { AppProps } from 'next/app';
import { globalStyles } from '@theme/globalStyle';

function MyApp({ Component, pageProps }: AppProps) {
  return (
    <>
      {globalStyles}
      <Component {...pageProps} />
    </>
  );
}
export default MyApp;
