import {NextUIProvider} from "@nextui-org/react";
import React from "react";
import NavigationBar from "@/app/Navbar";

export default function Home() {
    return (
        <NextUIProvider>
            {/*<NavigationBar/>*/}
            <main className="container mx-auto px-4 py-8 justify-items-center">
                <h1 className="text-2xl font-bold mb-4 justify-start">Welcome to Bookmarker</h1>
            </main>
        </NextUIProvider>
    );
}
