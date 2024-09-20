import {NextPage} from "next";
import React from "react";
import {Navbar} from "@nextui-org/react";

const AddBookMark: NextPage = () => {
    return (
        <div>
            <main className="container mx-auto px-4 py-8 justify-items-center">
                <h1 className="text-2xl font-bold mb-4 justify-start">Add to Bookmarks</h1>
            </main>
        </div>
    )
}

export default AddBookMark;