import { Button, Card, CardActionArea, CardContent, TextField, Typography } from '@mui/material'
import React, { useEffect, useState } from 'react'

const Login = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [isDisable, setIsDisable] = useState(true)

    const handleLogin = () => {
        // Integrate Api here for login
        console.log(email, " this ", password);
        resetForm()
    }
    useEffect(() => {
        setIsDisable(email === '' ||
            password === '')
    }, [email, password])

    const resetForm = () => {
        setEmail('')
        setPassword('')
    }
    return (
        <Card sx={{ maxWidth: 600 }}>
            <CardActionArea>
                <CardContent>
                    <Typography gutterBottom variant="h5" component="div">
                        Login
                    </Typography>
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="Email"
                        multiline
                        maxRows={4}
                        name='email'
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <TextField style={{ width: "100%", marginBottom: '5px' }}
                        id="outlined-multiline-flexible"
                        label="password"
                        multiline
                        maxRows={4}
                        name='password'
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    <Button disabled={isDisable} variant="contained" onClick={handleLogin}>Login</Button>
                </CardContent>
            </CardActionArea>
        </Card>
    )
}

export default Login