import logo from '../assets/logo.png'
import { useEffect } from 'react'
export default function Navbar() {

    useEffect(() => {
        fetch('api/v1')
        .then(res => {
            res.json()
        })
        .then(data => {
            console.log("The data is " + data)
        })
    }) 

    return (
        <nav>
            <div className="nav--=logo">
                <img src={logo} className="logo--image"/>
                <h1 className="logo--name">Meme Generator</h1>
            </div>
            <p className='nav--title'>React Course - Project</p>
        </nav>
    )
}