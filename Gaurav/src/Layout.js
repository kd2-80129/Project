import React from 'react'
import Navbar from './common/Navbar'
import Footer from './common/Footer'

function Layout(props) {
    return (
        <div style={{ height: "100vh" }}>
            <Navbar />
            <div style={{
                display: "flex",
                justifyContent: "center",
                alignItems: "center",
                maxHeight: '95vh',
                overflowY: 'auto',
                height: '95vh'
            }} >
                {props.children}
            </div>
            <Footer/>
        </div>
    )
}

export default Layout