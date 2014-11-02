<?php
App::uses('Controller', 'Controller');

class TracksController extends Controller {
//	public $components = array('RequestHandler');
		
	public function sample($id = null) {
		if (!$id) {
			throw new NotFoundException(__('Invalid post'));
		}
		$session = $this->Track->findById($id);
		if (!$session) {
            throw new NotFoundException(__('Invalid post'));
        }
		$this->viewClass = 'Json';
		$this->set('session', $session);
	}
}
