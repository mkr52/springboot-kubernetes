/** @type {import('next').NextConfig} */
const nextConfig = {
    reactStrictMode: true,
    async redirects() {
        return [
            {
                source: '/',
                destination: '/bookmarks',
                permanent: true,
            },
        ];
    }
};

export default nextConfig;
