import {Button, Link, Navbar, NavbarBrand, NavbarContent, NavbarItem} from "@nextui-org/react";
import React from "react";

const NavigationBar = () => {
    return (
        <Navbar>
            <NavbarBrand>
                <Link href="/"><p className="font-bold text-inherit">Bookmarker</p></Link>
            </NavbarBrand>
            <NavbarContent justify="end">
                <NavbarItem>
                    <Button as={Link} color="primary" href="/bookmarks/add" variant="flat">
                        Add Bookmark
                    </Button>
                </NavbarItem>
            </NavbarContent>
        </Navbar>
    );
}

export default NavigationBar;