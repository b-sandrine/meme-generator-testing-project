import logo from '../assets/logo.png'
import { useEffect, useState } from 'react'
export default function Navbar() {

    const [data, setData ] = useState();
    var data1 = [];
    useEffect(() => {
        fetch('http://localhost:8080/api/meme/all-memes')
        .then(res => res.json())
        .catch(err =>  {
            console.log("Error " + err)
        })
    }) 

    return (
        <>
            <nav>
                <div className="nav--logo">
                    <img src={logo} className="logo--image"/>
                    <h1 className="logo--name">Meme Generator</h1>
                </div>
                <p className='nav--title'>React Course - Project</p>
            </nav>
        </>
    )
}