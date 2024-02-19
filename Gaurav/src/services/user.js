import axios from 'axios'
import config from './config'

export async function signin(email, password) {
  const body = { email, password }
  const url = `${config.server}/user/signin`
  try {
    const result = await axios.post(url, body)
    // sending the json body from response
    return result.data
  } catch (ex) {
    console.log(ex)
    return { status: 'error', error: 'network error' }
  }
}
