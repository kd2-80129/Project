import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { CardActionArea } from '@mui/material';

export default function PickOption(props) {
    return (
        <div>
            <Card style={{ margin: "20px 40px" }} sx={{ maxWidth: 345 }}>
                <CardActionArea >
                    <CardContent>
                        <Typography gutterBottom variant="h5" component="div">
                            {props.data.name}
                        </Typography>
                        {props.data.image}
                    </CardContent>
                </CardActionArea>
            </Card>
        </div>
    );
}