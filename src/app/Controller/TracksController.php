<?php
App::uses('Controller', 'Controller');

class TracksController extends Controller {
//	public $components = array('RequestHandler');
		
	public function record($id = null) {
		if (!$id) {
			throw new NotFoundException(__('Invalid post'));
		}
		$track = $this->Track->findById($id)['Track'];
		if (!$track) {
            throw new NotFoundException(__('Invalid post'));
        }
		$this->viewClass = 'Json';
		$result = json_decode($track['actions'], true);
		$this->set(compact('result'));
		$this->set('_serialize', 'result');
	}
}
